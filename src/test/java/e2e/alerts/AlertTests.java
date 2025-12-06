// This class contains test cases that verify the functionality of alerts on the JavaScript Alerts page.

package e2e.alerts;

import e2e.base.BaseTests;
import io.qameta.allure.Allure;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import static org.testng.Assert.*;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class AlertTests extends BaseTests {

    Faker faker = new Faker();
    String alertText = "You successfully clicked an alert";
    String inputText = faker.lorem().sentence();

    @Test
    public void verifyAlertIsAcceptedSuccessfully(){
        // Given
        var alertsPage = homePage.navigateToJavaScriptAlerts();

        // When
        alertsPage.clickAlertButton();
        alertsPage.acceptJavaScriptAlert();

        // Then
        alertsPage.verifyResultText(alertText);
    }

    @Test
    public void verifyAlertIsDismissedSuccessfully(){
        // Given
        var alertsPage = homePage.navigateToJavaScriptAlerts();

        // When
        alertsPage.clickConfirmButton();
        String text = alertsPage.getAlertText();
        alertsPage.dismissJavaScriptAlert();

        // Then
        Allure.step("Verify dismissed alert text", () ->
                assertEquals(text,
                        "I am a JS Confirm",
                        "Alert text mismatch.")
        );
    }

    @Test
    public void verifyPromptAlertAcceptsInputText(){
        // Given
        var alertsPage = homePage.navigateToJavaScriptAlerts();

        // When
        alertsPage.clickPromptButton();
        alertsPage.setAlertInputText(inputText);
        alertsPage.acceptJavaScriptAlert();

        // Then
        alertsPage.verifyResultText("You entered: " + inputText);
    }
}
