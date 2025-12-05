// This class provides methods to interact with the page elements and retrieve information.

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicLoadingExample1Page extends BasePage {

    private final By startButton = By.xpath("//button[.='Start']");
    private final By finishText = By.id("finish");
    private final By loadingIndicator = By.id("loading");

    public DynamicLoadingExample1Page(WebDriver driver){
        super(driver);
    }

    // Clicks the Start button and waits for the loading indicator to disappear.
    public void clickStartButtonAndWait(){
        wait.until(ExpectedConditions.elementToBeClickable(startButton)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIndicator));
    }

    // Retrieves the text of the finish element.
    public String getFinishText() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(finishText));
        return element.getText().trim();
    }
}
