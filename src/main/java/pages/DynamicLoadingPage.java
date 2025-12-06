// This class provides a constructor to initialize the WebDriver instance and contains methods to interact with the page.

package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage extends BasePage {

    private final By example1Link = By.cssSelector("[href='/dynamic_loading/1']");

    public DynamicLoadingPage(WebDriver driver){
        super(driver);
    }

    public DynamicLoadingExample1Page navigateToExample1() {
        return Allure.step("Navigate to Dynamic Loading Example 1 page", () -> {
            driver.findElement(example1Link).click();
            return new DynamicLoadingExample1Page(driver);
        });
    }
}
