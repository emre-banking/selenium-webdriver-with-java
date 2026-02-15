package e2e.base;

import e2e.cucumber.CucumberTestContext;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Method;

public class AllureListener implements ITestListener {

    private static final Logger logger = LoggerFactory.getLogger(AllureListener.class);

    private static String getTestMethodName(ITestResult iTestResult) {
        String methodName = iTestResult.getMethod().getConstructorOrMethod().getName();
        if (!"runScenario".equals(methodName)) {
            return methodName;
        }

        Object[] parameters = iTestResult.getParameters();
        for (Object parameter : parameters) {
            if (parameter == null) {
                continue;
            }

            String scenarioName = extractScenarioName(parameter);
            if (scenarioName != null && !scenarioName.isBlank()) {
                return scenarioName;
            }
        }

        return methodName;
    }

    private static String extractScenarioName(Object parameter) {
        try {
            Method getPickle = parameter.getClass().getMethod("getPickle");
            Object pickle = getPickle.invoke(parameter);
            if (pickle != null) {
                Method getName = pickle.getClass().getMethod("getName");
                Object name = getName.invoke(pickle);
                if (name != null) {
                    return name.toString();
                }
            }
        } catch (Exception ignored) {
        }

        String asText = parameter.toString();
        return (asText != null && !asText.isBlank()) ? asText : null;
    }

    // --- Allure Attachments ---
    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] saveFailureScreenShot(WebDriver driver) {
        try {
            if (driver instanceof TakesScreenshot ts) {
                return ts.getScreenshotAs(OutputType.BYTES);
            }
        } catch (RuntimeException e) {
            logger.error("Screenshot could not be taken", e);
        }
        return new byte[0];
    }

    // --- Driver Extraction ---
    private WebDriver extractDriver(ITestResult result) {
        String methodName = result.getMethod().getConstructorOrMethod().getName();
        if ("runScenario".equals(methodName)) {
            try {
                return CucumberTestContext.getDriver();
            } catch (Exception ignored) {
                return null;
            }
        }

        try {
            Object testInstance = result.getInstance();
            Class<?> type = testInstance.getClass();
            while (type != null) {
                try {
                    var field = type.getDeclaredField("driver");
                    field.setAccessible(true);
                    Object value = field.get(testInstance);
                    if (value instanceof WebDriver webDriver) {
                        return webDriver;
                    }
                } catch (NoSuchFieldException ignored) {
                }
                type = type.getSuperclass();
            }
        } catch (Exception e) {
            logger.error("Could not extract WebDriver via reflection.", e);
        }
        return null;
    }

    // --- Listener Events ---
    @Override
    public void onStart(ITestContext context) {
        logger.info("=== SUITE START: {} ===", context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        int passed = context.getPassedTests().size();
        int failed = context.getFailedTests().size();
        int skipped = context.getSkippedTests().size();
        logger.info("=== SUITE END: {} | passed={} failed={} skipped={} ===", context.getName(), passed, failed, skipped);
    }

    @Override
    public void onTestStart(ITestResult result) {
        // no-op: per-test start logs intentionally suppressed
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = getTestMethodName(result);
        logger.info("Test ended: {} | status=passed", testName);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String method = getTestMethodName(result);
        logger.error("Test failed: {}", method);
        String runnerMethod = result.getMethod().getConstructorOrMethod().getName();
        if ("runScenario".equals(runnerMethod)) {
            logger.info("Failure screenshot is attached by Cucumber @After hook.");
            return;
        }

        WebDriver driver = extractDriver(result);
        if (driver != null) {
            try {
                logger.info("[FAILURE ARTIFACT] screenshot | {}", method);
                saveFailureScreenShot(driver); // Allure attachment (same thread)
            } catch (Throwable t) {
                logger.error("Screenshot capture failed for test {}", method, t);
            }
        } else {
            logger.error("Driver was null — screenshot could not be captured for {}", method);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = getTestMethodName(result);
        logger.warn("Test ended: {} | status=skipped", testName);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.warn("Test partly failed but within success ratio: {}", getTestMethodName(result));
    }
}