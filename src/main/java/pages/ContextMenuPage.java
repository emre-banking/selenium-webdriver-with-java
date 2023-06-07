// This class represents the Context Menu Page of the application.
// It provides methods to perform actions related to the context menu.
// The constructor takes a WebDriver instance to interact with the browser.

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {

    private WebDriver driver;
    private By frame = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver){
        this.driver=driver;
    }

    // Performs a context click on the specified target element.
    public void contextClick(){
        Actions actions = new Actions(driver);
        WebElement target = driver.findElement(frame);
        actions.contextClick(target).perform();
    }

    // Retrieves the text displayed in the alert dialog.
    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }

    // Accepts the alert dialog by clicking the "OK" button.
    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }
}
