// This class provides a constructor to initialize the WebDriver instance and contains methods to interact with the page.

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JavaScriptAlertsPage extends BasePage {

    private final By alertButton = By.xpath("//button[.='Click for JS Alert']");
    private final By confirmButton = By.xpath("//button[.='Click for JS Confirm']");
    private final By promptButton = By.xpath("//button[.='Click for JS Prompt']");
    private final By result = By.id("result");

    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }

    // Clicks the "Click for JS Alert" button
    public void clickAlertButton() {
        wait.until(ExpectedConditions.elementToBeClickable(alertButton)).click();
    }

    // Clicks the "Click for JS Confirm" button
    public void clickConfirmButton() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton)).click();
    }

    // Clicks the "Click for JS Prompt" button
    public void clickPromptButton() {
        wait.until(ExpectedConditions.elementToBeClickable(promptButton)).click();
    }

    // Accepts the JavaScript alert
    public void acceptJavaScriptAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    // Dismisses the JavaScript alert
    public void dismissJavaScriptAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
    }

    // Returns the text of the JavaScript alert
    public String getAlertText() {
        return wait.until(ExpectedConditions.alertIsPresent()).getText();
    }

    // Sets the input text in the JavaScript prompt
    public void setAlertInputText(String inputText) {
        wait.until(ExpectedConditions.alertIsPresent()).sendKeys(inputText);
    }

    // Returns the text of the result element on the page
    public String getAlertResultText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(result)).getText().trim();
    }
}
