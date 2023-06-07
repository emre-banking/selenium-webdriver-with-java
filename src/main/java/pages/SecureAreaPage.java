// This class represents the Secure Area Page of the application.
// It provides a constructor to initialize the WebDriver instance and contains a method to retrieve the alert text.

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {

    private WebDriver driver;
    private By statusAlert = By.id("flash");

    public SecureAreaPage(WebDriver driver){
        this.driver=driver;
    }

    // Retrieves the text of the status alert on the Secure Area Page
    public String getAlertText(){
        return driver.findElement(statusAlert).getText();
    }
}
