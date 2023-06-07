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
        driver.findElement(example1Link).click();
        return new DynamicLoadingExample1Page(driver);
    }

    public DynamicLoadingExample2Page clickExample2(){
        driver.findElement(example2Link).click();
        return new DynamicLoadingExample2Page(driver);
    }
}
