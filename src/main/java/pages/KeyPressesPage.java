// This class provides a constructor to initialize the WebDriver instance and contains methods to interact with the page.

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class KeyPressesPage extends BasePage {

    private final By textField = By.id("target");
    private final By resultText = By.id("result");

    public KeyPressesPage(WebDriver driver){
        super(driver);
    }

    // Enters the given text in the text field
    public void enterText(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(textField)).sendKeys(text);
    }

    // Returns the text of the result element on the page
    public String getResult(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resultText)).getText().trim();
    }
}
