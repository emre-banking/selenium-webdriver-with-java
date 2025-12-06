// This class provides a constructor to initialize the WebDriver instance and contains methods related to interacting with the editor.

package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WYSIWYGEditorPage extends BasePage {

    private final By textArea = By.id("tinymce");
    private final By decreaseIndentButton = By.cssSelector("[aria-label='Decrease indent']");

    public WYSIWYGEditorPage(WebDriver driver){
        super(driver);
    }

    public void clearTextArea() {
        Allure.step("Clear text area content", () -> {
            switchToEditArea();
            driver.findElement(textArea)
                    .sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
            switchToMainArea();
        });
    }

    public void setTextArea(String text) {
        Allure.step("Set text area content: " + text, () -> {
            switchToEditArea();
            driver.findElement(textArea).sendKeys(text);
            switchToMainArea();
        });
    }

    // Clicks the "Decrease indent" button in the editor
    public void clickDecreaseIndent() {
        Allure.step("Click Decrease Indent button", () ->
                driver.findElement(decreaseIndentButton).click()
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
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }

    // Switches the driver's focus to the editor's iframe
    private void switchToEditArea(){
        String editorIframeId = "mce_0_ifr";
        driver.switchTo().frame(editorIframeId);
    }

    // Switches the driver's focus back to the main area from the editor's iframe
    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
}
