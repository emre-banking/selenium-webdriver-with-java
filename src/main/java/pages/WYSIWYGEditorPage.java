// This class represents the WYSIWYG Editor Page of the application.
// It provides a constructor to initialize the WebDriver instance and contains methods related to interacting with the editor.

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

    // Clears the content of the text area in the editor
    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        switchToMainArea();
    }

    // Sets the content of the text area in the editor
    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    // Retrieves the text from the text area in the editor
    public String getTextFromEditor(){
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }

    // Clicks the "Decrease indent" button in the editor
    public void clickDecreaseIndent(){
        driver.findElement(decreaseIndentButton).click();
    }

    // Switches the driver's focus to the editor's iframe
    private void switchToEditArea(){
        driver.switchTo().frame(editorIframeId);
    }

    // Switches the driver's focus back to the main area from the editor's iframe
    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
}
