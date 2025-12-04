// This class provides methods to perform actions related to the context menu.

package pages;

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
    public void contextClick() {
        actions.contextClick(getHotSpot()).perform();
    }

    // Retrieves the text displayed in the alert dialog.
    public String getAlertText() {
        return getAlert().getText();
    }

    // Accepts the alert dialog by clicking the "OK" button.
    public void acceptAlert() {
        getAlert().accept();
    }

    private WebElement getHotSpot() {
        return driver.findElement(hotSpotArea);
    }
}
