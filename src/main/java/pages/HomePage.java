package pages;

import constants.HomeLinks;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    public ContextMenuPage navigateToContextMenu() {
        return Allure.step("Navigate to Context Menu page",
                () -> navigateTo(HomeLinks.CONTEXT_MENU, ContextMenuPage.class)
        );
    }

    public DropdownPage navigateToDropdown(){
        return navigateTo(HomeLinks.DROPDOWN, DropdownPage.class);
    }

    public DynamicLoadingPage navigateToDynamicLoading(){
        return navigateTo(HomeLinks.DYNAMIC_LOADING, DynamicLoadingPage.class);
    }

    public HorizontalSliderPage navigateToHorizontalSlider(){
        return navigateTo(HomeLinks.HORIZONTAL_SLIDER, HorizontalSliderPage.class);
    }

    public HoversPage navigateToHovers(){
        return navigateTo(HomeLinks.HOVERS, HoversPage.class);
    }

    public JavaScriptAlertsPage navigateToJavaScriptAlerts(){
        return navigateTo(HomeLinks.JAVASCRIPT_ALERTS, JavaScriptAlertsPage.class);
    }

    public KeyPressesPage navigateToKeyPresses(){
        return navigateTo(HomeLinks.KEY_PRESSES, KeyPressesPage.class);
    }

    public LoginPage navigateToFormAuthentication(){
        return navigateTo(HomeLinks.FORM_AUTHENTICATION, LoginPage.class);
    }

    public WYSIWYGEditorPage navigateToWYSIWYGEditor(){
        return navigateTo(HomeLinks.WYSIWYG_EDITOR, WYSIWYGEditorPage.class);
    }
}
