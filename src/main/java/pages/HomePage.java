// This class represents the Home Page of the application.
// It provides methods to navigate to different pages and return the respective Page objects.
// The constructor takes a WebDriver instance to interact with the browser.

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    // Clicks on the "Context Menu" link and returns the ContextMenuPage object.
    public ContextMenuPage clickContextMenu(){
        clickLink("Context Menu");
        return new ContextMenuPage(driver);
    }

    // Clicks on the "Dropdown" link and returns the DropdownPage object.
    public DropdownPage clickDropdown(){
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    // Clicks on the "Dynamic Loading" link and returns the DynamicLoadingPage object.
    public DynamicLoadingPage clickDynamicLoading(){
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }

    // Clicks on the "Horizontal Slider" link and returns the HorizontalSliderPage object.
    public HorizontalSliderPage clickHorizontalSlider(){
        clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }

    // Clicks on the "Hovers" link and returns the HoversPage object.
    public HoversPage clickHovers(){
        clickLink("Hovers");
        return new HoversPage(driver);
    }

    // Clicks on the "JavaScript Alerts" link and returns the JavaScriptAlertsPage object.
    public JavaScriptAlertsPage clickJavaScriptAlerts(){
        clickLink("JavaScript Alerts");
        return new JavaScriptAlertsPage(driver);
    }

    // Clicks on the "Key Presses" link and returns the KeyPressesPage object.
    public KeyPressesPage clickKeyPresses(){
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }

    // Clicks on the "Form Authentication" link and returns the LoginPage object.
    public LoginPage clickFormAuthentication(){
        clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    // Clicks on the "WYSIWYG Editor" link and returns the WYSIWYGEditorPage object.
    public WYSIWYGEditorPage clickWYSIWYGEditor(){
        clickLink("WYSIWYG Editor");
        return new WYSIWYGEditorPage(driver);
    }

    // Private helper method to click on a link by its link text.
    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
}
