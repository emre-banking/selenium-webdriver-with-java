// This class represents the JavaScript Alerts Page of the application.
// It provides a constructor to initialize the WebDriver instance and contains methods to interact with the page.

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage {

    private WebDriver driver;
    private By alertButton = By.xpath("//button[.='Click for JS Alert']");
    private By confirmButton = By.xpath("//button[.='Click for JS Confirm']");
    private By promptButton = By.xpath("//button[.='Click for JS Prompt']");
    private By result = By.id("result");

    public JavaScriptAlertsPage(WebDriver driver){
        this.driver=driver;
    }

    // Clicks the "Click for JS Alert" button
    public void clickAlertButton(){
        driver.findElement(alertButton).click();
    }

    // Clicks the "Click for JS Confirm" button
    public void clickConfirmButton(){
        driver.findElement(confirmButton).click();
    }

    // Clicks the "Click for JS Prompt" button
    public void clickPromptButton(){
        driver.findElement(promptButton).click();
    }

    // Accepts the JavaScript alert
    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }

    // Dismisses the JavaScript alert
    public void alert_clickToDismiss(){
        driver.switchTo().alert().dismiss();
    }

    // Returns the text of the JavaScript alert
    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }

    // Returns the text of the result element on the page
    public String alert_getResult(){
        return driver.findElement(result).getText();
    }

    // Sets the input text in the JavaScript prompt
    public void alert_setInput(String text){
        driver.switchTo().alert().sendKeys(text);
    }
}
