package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;

public class KeyPressesPage {

    private WebDriver driver;
    private By textField = By.id("target");
    private By resultText = By.id("result");

    public KeyPressesPage(WebDriver driver){
        this.driver=driver;
    }

    public void enterText(String text){
        driver.findElement(textField).sendKeys(text);
    }

    public void enterPi(){
        enterText(Keys.chord(Keys.ALT,"p") + "= 3.14");
    }

    public String getResult(){
        return driver.findElement(resultText).getText();
    }
}
