// This class provides a constructor to initialize the WebDriver instance and contains methods related to interacting with the editor.

package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WYSIWYGEditorPage extends BasePage {

    private final By textArea = By.id("tinymce");

    public WYSIWYGEditorPage(WebDriver driver){
        super(driver);
    }

    public void assertEditorIsReadOnly() {
        Allure.step("Verify editor is read only", () -> {
            switchToEditArea();
            WebElement editor = driver.findElement(textArea);
            String contentEditable = editor.getAttribute("contenteditable");
            String readOnly = editor.getAttribute("readonly");
            switchToMainArea();

            boolean isReadOnly = "false".equalsIgnoreCase(contentEditable)
                    || "true".equalsIgnoreCase(readOnly)
                    || "readonly".equalsIgnoreCase(readOnly);

            Assert.assertTrue(isReadOnly, "Editor is expected to be read only.");
        });
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
