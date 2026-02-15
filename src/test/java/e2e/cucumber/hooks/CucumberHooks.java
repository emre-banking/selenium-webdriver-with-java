package e2e.cucumber.hooks;

import e2e.cucumber.CucumberTestContext;
import e2e.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CucumberHooks {

    static {
        Logger.getLogger("org.openqa.selenium.devtools.CdpVersionFinder").setLevel(Level.SEVERE);
    }

    private String baseUrl;

    @Before(order = 0)
    public void setUpDriver() {
        baseUrl = ConfigReader.getRequired("baseUrl");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");

        if (Boolean.parseBoolean(System.getenv().getOrDefault("CI", "false"))) {
            options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
        }

        WebDriver driver = new ChromeDriver(options);
        CucumberTestContext.setDriver(driver);
    }

    @Before(order = 1)
    public void goHome() {
        CucumberTestContext.getDriver().get(baseUrl);
    }

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = null;
        try {
            driver = CucumberTestContext.getDriver();
            if (scenario.isFailed() && driver instanceof TakesScreenshot screenshotDriver) {
                byte[] screenshot = screenshotDriver.getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment(
                        "Failure Screenshot",
                        "image/png",
                        new ByteArrayInputStream(screenshot),
                        "png"
                );
            }
        } finally {
            if (driver != null) {
                driver.quit();
            }
            CucumberTestContext.clear();
        }
    }
}
