// This class provides a constructor to initialize the WebDriver instance and contains methods related to interacting with the editor.

package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class WYSIWYGEditorPage extends BasePage {

    private final By textArea = By.id("tinymce");
    private final By editorIframe = By.id("mce_0_ifr");
    private final By decreaseIndentButton = By.cssSelector("[aria-label='Decrease indent']");

    public WYSIWYGEditorPage(WebDriver driver){
        super(driver);
    }

    public boolean isEditorReadOnly() {
        switchToEditArea();
        WebElement editor = driver.findElement(textArea);
        String contentEditable = editor.getAttribute("contenteditable");
        String readOnly = editor.getAttribute("readonly");
        switchToMainArea();

        return "false".equalsIgnoreCase(contentEditable)
                || "true".equalsIgnoreCase(readOnly)
                || "readonly".equalsIgnoreCase(readOnly);
    }

    public void clearTextArea() {
        Allure.step("Clear text area content", () -> {
            switchToEditArea();
            WebElement editor = wait.until(ExpectedConditions.visibilityOfElementLocated(textArea));
            ((JavascriptExecutor) driver).executeScript("arguments[0].textContent = '';", editor);
            switchToMainArea();
        });
    }

    public void setTextArea(String text) {
        Allure.step("Set text area content: " + text, () -> {
            switchToEditArea();
            WebElement editor = wait.until(ExpectedConditions.visibilityOfElementLocated(textArea));
            ((JavascriptExecutor) driver).executeScript("arguments[0].textContent = arguments[1];", editor, text);
            switchToMainArea();
        });
    }

    // Clicks the "Decrease indent" button in the editor
    public void clickDecreaseIndent() {
        Allure.step("Click Decrease Indent button", () ->
                wait.until(ExpectedConditions.elementToBeClickable(decreaseIndentButton)).click()
        );
    }

    public void assertEditorText(String expectedText) {
        Allure.step("Verify editor text equals: " + expectedText, () ->
                Assert.assertEquals(
                        getTextFromEditor(),
                        expectedText,
                        "Editor text mismatch."
                )
        );
    }

    // Retrieves the text from the text area in the editor
    private String getTextFromEditor(){
        switchToEditArea();
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(textArea)).getText();
        switchToMainArea();
        return text.trim();
    }

    // Switches the driver's focus to the editor's iframe
    private void switchToEditArea(){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(editorIframe));
    }

    // Switches the driver's focus back to the main area from the editor's iframe
    private void switchToMainArea(){
        driver.switchTo().defaultContent();
    }
}
