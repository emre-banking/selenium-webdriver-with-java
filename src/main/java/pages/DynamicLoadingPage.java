// This class represents the Dynamic Loading Page of the application.
// It provides a constructor to initialize the WebDriver instance and contains methods to interact with the page.

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {

    private WebDriver driver;
    private By example1Link = By.cssSelector("[href='/dynamic_loading/1']");
    private By example2Link = By.cssSelector("[href='/dynamic_loading/2']");

    public DynamicLoadingPage(WebDriver driver){
        this.driver=driver;
    }

    public DynamicLoadingExample1Page clickExample1(){
        // Clicks on the Example 1 link
        driver.findElement(example1Link).click();
        // Returns an instance of the DynamicLoadingExample1Page class
        return new DynamicLoadingExample1Page(driver);
    }

    public DynamicLoadingExample2Page clickExample2(){
        // Clicks on the Example 2 link
        driver.findElement(example2Link).click();
        // Returns an instance of the DynamicLoadingExample2Page class
        return new DynamicLoadingExample2Page(driver);
    }
}
