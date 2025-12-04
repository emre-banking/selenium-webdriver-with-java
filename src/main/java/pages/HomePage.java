// This class provides methods to navigate to the different pages and return the respective Page objects.

package pages;

import constants.HomeLinks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private static final Duration TIMEOUT = Duration.ofSeconds(5);
    private final WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public ContextMenuPage clickContextMenu(){
        return navigateTo(HomeLinks.CONTEXT_MENU, ContextMenuPage.class);
    }

    public DropdownPage clickDropdown(){
        return navigateTo(HomeLinks.DROPDOWN, DropdownPage.class);
    }

    public DynamicLoadingPage clickDynamicLoading(){
        return navigateTo(HomeLinks.DYNAMIC_LOADING, DynamicLoadingPage.class);
    }

    public HorizontalSliderPage clickHorizontalSlider(){
        return navigateTo(HomeLinks.HORIZONTAL_SLIDER, HorizontalSliderPage.class);
    }

    public HoversPage clickHovers(){
        return navigateTo(HomeLinks.HOVERS, HoversPage.class);
    }

    public JavaScriptAlertsPage clickJavaScriptAlerts(){
        return navigateTo(HomeLinks.JAVASCRIPT_ALERTS, JavaScriptAlertsPage.class);
    }

    public KeyPressesPage clickKeyPresses(){
        return navigateTo(HomeLinks.KEY_PRESSES, KeyPressesPage.class);
    }

    public LoginPage clickFormAuthentication(){
        return navigateTo(HomeLinks.FORM_AUTHENTICATION, LoginPage.class);
    }

    public WYSIWYGEditorPage clickWYSIWYGEditor(){
        return navigateTo(HomeLinks.WYSIWYG_EDITOR, WYSIWYGEditorPage.class);
    }

    private void clickLink(String linkText){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        By locator = By.xpath("//a[normalize-space()='" + linkText + "']");
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(locator));
        link.click();
    }

    private <T> T navigateTo(HomeLinks link, Class<T> pageClass){
        clickLink(link.toString());
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create page: " + pageClass.getSimpleName(), e);
        }
    }
}
