package e2e.base;

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
        try {
            Object testInstance = result.getInstance();

            return (WebDriver) testInstance
                    .getClass()
                    .getSuperclass()          // BaseTests
                    .getDeclaredField("driver")
                    .get(testInstance);
        } catch (Exception e) {
            logger.error("Could not extract WebDriver via reflection.", e);
            return null;
        }
    }

    // --- Listener Events ---
    @Override
    public void onStart(ITestContext context) {
        logger.info("Test context started: {}", context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test context finished: {}", context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test started: {}", getTestMethodName(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test succeeded: {}", getTestMethodName(result));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String method = getTestMethodName(result);
        logger.error("Test failed: {}", method);
        WebDriver driver = extractDriver(result);
        if (driver != null) {
            try {
                logger.info("Capturing screenshot for failed test: {}", method);
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
        logger.warn("Test skipped: {}", getTestMethodName(result));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.warn("Test partly failed but within success ratio: {}", getTestMethodName(result));
    }
}