// This class contains test cases that verify the functionality of alerts on the JavaScript Alerts page.

package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AlertTests extends BaseTests {

    @Test
    public void testAcceptAlert(){
        // Click on the JavaScript Alerts link in the home page and navigate to the JavaScript Alerts page
        var alertsPage = homePage.clickJavaScriptAlerts();

        // Click on the "Click for JS Alert" button to trigger an alert
        alertsPage.clickAlertButton();

        // Accept the alert
        alertsPage.alert_clickToAccept();

        // Verify the result text after accepting the alert
        assertEquals(alertsPage.alert_getResult(), "You successfully clicked an alert");
    }

    @Test
    public void testDismissAlert(){
        // Click on the JavaScript Alerts link in the home page and navigate to the JavaScript Alerts page
        var alertsPage = homePage.clickJavaScriptAlerts();

        // Click on the "Click for JS Confirm" button to trigger a confirmation alert
        alertsPage.clickConfirmButton();

        // Get the text of the alert and dismiss it
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();

        // Verify the expected text of the alert after dismissing it
        assertEquals(text, "I am a JS Confirm");
    }

    @Test
    public void testSetInputInAlert(){
        // Click on the JavaScript Alerts link in the home page and navigate to the JavaScript Alerts page
        var alertsPage = homePage.clickJavaScriptAlerts();

        // Click on the "Click for JS Prompt" button to trigger a prompt alert
        alertsPage.clickPromptButton();

        // Set the input text in the alert and accept it
        String text = "TAU rocks!";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAccept();

        // Verify the result text after accepting the alert with the input text
        assertEquals(alertsPage.alert_getResult(), "You entered: " + text);
    }
}
