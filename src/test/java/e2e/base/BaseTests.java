// This class serves as the base class for all test classes in the test automation framework.
// It initializes the WebDriver instance, sets up the ChromeDriver using the driver in the project, and defines common setup and teardown methods.

package e2e.base;

import e2e.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class BaseTests {
    protected WebDriver driver;
    protected HomePage homePage;
    private String baseUrl;

    // Set up WebDriver and initialize the home page
    @BeforeClass
    public void setUp() {
        baseUrl = ConfigReader.getRequired("baseUrl");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");

        if (Boolean.parseBoolean(System.getenv().getOrDefault("CI", "false"))) {
            options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
        }

        driver = new ChromeDriver(options);
        homePage = new HomePage(driver);
    }

    // Navigate to the home page URL before each test method
    @BeforeMethod
    public void goHome() {
        driver.get(baseUrl);
    }

    // Quit the WebDriver instance after all tests have finished
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
