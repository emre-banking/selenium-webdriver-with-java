package pages;

import constants.HomeLinks;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
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
}
