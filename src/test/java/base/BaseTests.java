// This class serves as the base class for all test classes in the test automation framework.
// It initializes the WebDriver instance, sets up the ChromeDriver using the driver in the project, and defines common setup and teardown methods.

package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.ConfigReader;

public class BaseTests {
    protected WebDriver driver;
    protected HomePage homePage;

    // Set up WebDriver and initialize the home page
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    // Navigate to the home page URL before each test method
    @BeforeMethod
    public void goHome() {
        driver.get(ConfigReader.get("baseUrl"));
    }

    // Quit the WebDriver instance after all tests have finished
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
