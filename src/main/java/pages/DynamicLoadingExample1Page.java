// This class provides methods to interact with the page elements and retrieve information.

package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DynamicLoadingExample1Page extends BasePage {

    private final By startButton = By.xpath("//button[.='Start']");
    private final By finishText = By.id("finish");
    private final By loadingIndicator = By.id("loading");

    public DynamicLoadingExample1Page(WebDriver driver){
        super(driver);
    }

    public void clickStartButtonAndWait() {
        Allure.step("Click Start button and wait for loading to finish", () -> {
            wait.until(ExpectedConditions.elementToBeClickable(startButton)).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIndicator));
        });
    }

    public void assertLoadedText(String expectedText) {
        Allure.step("Verify loaded text equals expected value", () ->
                Assert.assertEquals(
                        getLoadedText(),
                        expectedText,
                        "Loaded text mismatch."
                )
        );
    }

    // Retrieves the text of the finish element.
    private String getLoadedText() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(finishText));
        return element.getText().trim();
    }
}
