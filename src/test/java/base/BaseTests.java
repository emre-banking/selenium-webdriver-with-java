// This class serves as the base class for all test classes in the test automation framework.
// It initializes the WebDriver instance, sets up the ChromeDriver using WebDriverManager, and defines common setup and teardown methods.

package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        // Set up the ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        goHome();

        // Initialize the homePage object
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    // Navigate to the home page URL before each test method
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass
    // Quit the WebDriver instance after all tests have finished
    public void tearDown() {
        driver.quit();
    }
}
