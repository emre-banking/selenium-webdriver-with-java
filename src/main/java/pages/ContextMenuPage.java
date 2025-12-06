// This class provides methods to perform actions related to the context menu.

package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage extends BasePage {

    private final Actions actions;
    private final By hotSpotArea = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver){
        super(driver);
        this.actions = new Actions(driver);
    }

    // Performs a context click on the specified target element.
    public void openContextMenu() {
        Allure.step("Open context menu page", () -> actions.contextClick(getHotSpot()).perform());
    }

    // Retrieves the text displayed in the alert dialog.
    public String getAlertText() {
        return getAlert().getText();
    }

    private WebElement getHotSpot() {
        return driver.findElement(hotSpotArea);
    }

    private Alert getAlert() {
        return driver.switchTo().alert();
    }
}
