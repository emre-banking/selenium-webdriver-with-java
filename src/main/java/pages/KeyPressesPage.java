// This class provides a constructor to initialize the WebDriver instance and contains methods to interact with the page.

package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class KeyPressesPage extends BasePage {

    private final By textField = By.id("target");
    private final By resultText = By.id("result");

    public KeyPressesPage(WebDriver driver){
        super(driver);
    }

    public void enterText(String text) {
        Allure.step("Enter text into the field", () ->
                wait.until(ExpectedConditions.visibilityOfElementLocated(textField))
                .sendKeys(text));
    }

    public void assertKeyPressResult(String expectedResult) {
        Allure.step("Verify key press result is: " + expectedResult, () ->
                Assert.assertEquals(
                        getResult(),
                        expectedResult,
                        "Key press result mismatch."
                )
        );
    }

    // Returns the text of the result element on the page
    private String getResult(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resultText)).getText().trim();
    }
}
