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

    public void clickAlertButton(){
        driver.findElement(alertButton).click();
    }

    public void clickConfirmButton(){
        driver.findElement(confirmButton).click();
    }

    public void clickPromptButton(){
        driver.findElement(promptButton).click();
    }

    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }

    public void alert_clickToDismiss(){
        driver.switchTo().alert().dismiss();
    }

    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }

    public String alert_getResult(){
        return driver.findElement(result).getText();
    }

    public void alert_setInput(String text){
        driver.switchTo().alert().sendKeys(text);
    }
}
