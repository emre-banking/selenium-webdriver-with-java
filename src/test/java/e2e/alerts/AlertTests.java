// This class contains test cases that verify the functionality of alerts on the JavaScript Alerts page.

package e2e.alerts;

import e2e.base.BaseTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import static org.testng.Assert.*;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class AlertTests extends BaseTests {

    Faker faker = new Faker();
    String inputText = faker.lorem().sentence();

    @Test
    public void verifyAlertIsAcceptedSuccessfully(){
        // Given
        var alertsPage = homePage.navigateToJavaScriptAlerts();

        // When
        alertsPage.clickAlertButton();
        alertsPage.acceptJavaScriptAlert();

        // Then
        assertEquals(alertsPage.getAlertResultText(),
                "You successfully clicked an alert",
                "Alert result text mismatch.");
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
        assertEquals(text,
                "I am a JS Confirm",
                "Alert text mismatch.");
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
        assertEquals(alertsPage.getAlertResultText(),
                "You entered: " + inputText,
                "Prompt result text mismatch.");
    }
}
