// This class provides a constructor to initialize the WebDriver instance and contains a method to retrieve the alert text.

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

public class SecureAreaPage extends BasePage {

    private final By statusAlert = By.id("flash");

    public SecureAreaPage(WebDriver driver){
        super(driver);
    }

    // Retrieves the text of the status alert on the Secure Area Page
    public String getAlertText() {
        return Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOfElementLocated(statusAlert)))
                .getText()
                .trim();
    }
}
