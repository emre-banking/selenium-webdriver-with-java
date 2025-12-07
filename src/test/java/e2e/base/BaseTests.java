// This class serves as the base class for all test classes in the test automation framework.
// It initializes the WebDriver instance, sets up the ChromeDriver using the driver in the project, and defines common setup and teardown methods.

package e2e.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.HomePage;
import e2e.utils.ConfigReader;

@Listeners({
        io.qameta.allure.testng.AllureTestNg.class,
        // AllureListener.class
})
public class BaseTests {
    protected WebDriver driver;
    protected HomePage homePage;
    private String baseUrl;

    // Set up WebDriver and initialize the home page
    @BeforeClass
    public void setUp() {
        baseUrl = ConfigReader.get("baseUrl");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
