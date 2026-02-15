package e2e.cucumber;

import org.openqa.selenium.WebDriver;
import pages.HomePage;

public final class CucumberTestContext {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    private static final ThreadLocal<HomePage> HOME_PAGE = new ThreadLocal<>();

    private CucumberTestContext() {
    }

    public static void setDriver(WebDriver driver) {
        DRIVER.set(driver);
        HOME_PAGE.set(new HomePage(driver));
    }

    public static WebDriver getDriver() {
        WebDriver driver = DRIVER.get();
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized for current scenario.");
        }
        return driver;
    }

    public static HomePage getHomePage() {
        HomePage homePage = HOME_PAGE.get();
        if (homePage == null) {
            throw new IllegalStateException("HomePage is not initialized for current scenario.");
        }
        return homePage;
    }

    public static void clear() {
        DRIVER.remove();
        HOME_PAGE.remove();
    }
}
