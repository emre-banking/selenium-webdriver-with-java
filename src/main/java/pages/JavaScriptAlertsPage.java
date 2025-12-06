// This class provides a constructor to initialize the WebDriver instance and contains methods to interact with the page.

package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class JavaScriptAlertsPage extends BasePage {

    private final By alertButton = By.xpath("//button[.='Click for JS Alert']");
    private final By confirmButton = By.xpath("//button[.='Click for JS Confirm']");
    private final By promptButton = By.xpath("//button[.='Click for JS Prompt']");
    private final By result = By.id("result");

    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }

    public void verifyResultText(String expectedText) {
        Allure.step("Verify alert text", () ->
                Assert.assertEquals(
                        getAlertResultText(),
                        expectedText,
                        "Result text mismatch."
                )
        );
    }

    // Clicks the "Click for JS Alert" button
    public void clickAlertButton() {
        Allure.step("Click JS Alert button", () ->
                wait.until(ExpectedConditions.elementToBeClickable(alertButton)).click()
        );
    }

    // Clicks the "Click for JS Confirm" button
    public void clickConfirmButton() {
        Allure.step("Click JS Confirm button", () ->
                wait.until(ExpectedConditions.elementToBeClickable(confirmButton)).click()
        );
    }

    // Clicks the "Click for JS Prompt" button
    public void clickPromptButton() {
        Allure.step("Click JS Prompt button", () ->
                wait.until(ExpectedConditions.elementToBeClickable(promptButton)).click()
        );
    }

    // Accepts the JavaScript alert
    public void acceptJavaScriptAlert() {
        Allure.step("Accept JavaScript alert", () ->
                wait.until(ExpectedConditions.alertIsPresent()).accept()
        );
    }

    // Dismisses the JavaScript alert
    public void dismissJavaScriptAlert() {
        Allure.step("Dismiss JavaScript alert", () ->
                wait.until(ExpectedConditions.alertIsPresent()).dismiss()
        );
    }

    // Returns the text of the JavaScript alert
    public String getAlertText() {
        return wait.until(ExpectedConditions.alertIsPresent()).getText();
    }

    // Sets the input text in the JavaScript prompt
    public void setAlertInputText(String inputText) {
        Allure.step("Set alert input text: " + inputText, () ->
                wait.until(ExpectedConditions.alertIsPresent()).sendKeys(inputText)
        );
    }

    // Returns the text of the result element on the page
    private String getAlertResultText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(result)).getText().trim();
    }
}
