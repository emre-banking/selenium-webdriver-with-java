package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class WYSIWYGEditorPage {

    private WebDriver driver;
    private String editorIframeId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By decreaseIndentButton = By.cssSelector("[aria-label='Decrease indent']");

    public WYSIWYGEditorPage(WebDriver driver){
        this.driver=driver;
    }

    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        switchToMainArea();
    }

    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    public String getTextFromEditor(){
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }

    public void clickDecreaseIndent(){
        driver.findElement(decreaseIndentButton).click();
    }

    private void switchToEditArea(){
        driver.switchTo().frame(editorIframeId);
    }

    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
}
