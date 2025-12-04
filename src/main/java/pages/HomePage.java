// This class represents the Home Page of the application.
// It provides methods to navigate to different pages and return the respective Page objects.
// The constructor takes a WebDriver instance to interact with the browser.

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public ContextMenuPage clickContextMenu(){
        return navigateTo("Context Menu", ContextMenuPage.class);
    }

    public DropdownPage clickDropdown(){
        return navigateTo("Dropdown", DropdownPage.class);
    }

    public DynamicLoadingPage clickDynamicLoading(){
        return navigateTo("Dynamic Loading", DynamicLoadingPage.class);
    }

    public HorizontalSliderPage clickHorizontalSlider(){
        return navigateTo("Horizontal Slider", HorizontalSliderPage.class);
    }

    public HoversPage clickHovers(){
        return navigateTo("Hovers", HoversPage.class);
    }

    public JavaScriptAlertsPage clickJavaScriptAlerts(){
        return navigateTo("JavaScript Alerts", JavaScriptAlertsPage.class);
    }

    public KeyPressesPage clickKeyPresses(){
        return navigateTo("Key Presses", KeyPressesPage.class);
    }

    public LoginPage clickFormAuthentication(){
        return navigateTo("Form Authentication", LoginPage.class);
    }

    public WYSIWYGEditorPage clickWYSIWYGEditor(){
        return navigateTo("WYSIWYG Editor", WYSIWYGEditorPage.class);
    }

    private void clickLink(String linkText){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By locator = By.xpath("//a[normalize-space()='" + linkText + "']");
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(locator));
        link.click();
    }

    private <T> T navigateTo(String linkText, Class<T> pageClass){
        clickLink(linkText);
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create page: " + pageClass.getSimpleName(), e);
        }
    }
}
