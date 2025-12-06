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

    public DropdownPage navigateToDropdown() {
        return Allure.step("Navigate to Dropdown page",
                () -> navigateTo(HomeLinks.DROPDOWN, DropdownPage.class)
        );
    }

    public DynamicLoadingPage navigateToDynamicLoading() {
        return Allure.step("Navigate to Dynamic Loading page",
                () -> navigateTo(HomeLinks.DYNAMIC_LOADING, DynamicLoadingPage.class)
        );
    }

    public HorizontalSliderPage navigateToHorizontalSlider() {
        return Allure.step("Navigate to Horizontal Slider page",
                () -> navigateTo(HomeLinks.HORIZONTAL_SLIDER, HorizontalSliderPage.class)
        );
    }

    public HoversPage navigateToHovers() {
        return Allure.step("Navigate to Hovers page",
                () -> navigateTo(HomeLinks.HOVERS, HoversPage.class)
        );
    }

    public JavaScriptAlertsPage navigateToJavaScriptAlerts() {
        return Allure.step("Navigate to JavaScript Alerts page",
                () -> navigateTo(HomeLinks.JAVASCRIPT_ALERTS, JavaScriptAlertsPage.class)
        );
    }

    public KeyPressesPage navigateToKeyPresses() {
        return Allure.step("Navigate to Key Presses page",
                () -> navigateTo(HomeLinks.KEY_PRESSES, KeyPressesPage.class)
        );
    }

    public LoginPage navigateToFormAuthentication() {
        return Allure.step("Navigate to Form Authentication page",
                () -> navigateTo(HomeLinks.FORM_AUTHENTICATION, LoginPage.class)
        );
    }

    public WYSIWYGEditorPage navigateToWYSIWYGEditor() {
        return Allure.step("Navigate to WYSIWYG Editor page",
                () -> navigateTo(HomeLinks.WYSIWYG_EDITOR, WYSIWYGEditorPage.class)
        );
    }
}
