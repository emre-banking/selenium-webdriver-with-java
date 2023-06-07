// This class represents the Key Presses Page of the application.
// It provides a constructor to initialize the WebDriver instance and contains methods to interact with the page.

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

    // Enters the given text in the text field
    public void enterText(String text){
        driver.findElement(textField).sendKeys(text);
    }

    // Enters the keystrokes for "Alt + p" followed by "= 3.14"
    public void enterPi(){
        enterText(Keys.chord(Keys.ALT,"p") + "= 3.14");
    }

    // Returns the text of the result element on the page
    public String getResult(){
        return driver.findElement(resultText).getText();
    }
}
