// This class serves as the base class for all test classes in the test automation framework.
// It initializes the WebDriver instance, sets up the ChromeDriver using the driver in the project, and defines common setup and teardown methods.

package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty(
                "webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe"
        );
        driver = new ChromeDriver();
        goHome();
        homePage = new HomePage(driver);
    }

    // Navigate to the home page URL before each test method
    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }

    // Quit the WebDriver instance after all tests have finished
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
