package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AlertTests extends BaseTests {

    @Test
    public void testAcceptAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.clickAlertButton();
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.alert_getResult(),"You successfully clicked an alert");
    }

    @Test
    public void testDismissAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.clickConfirmButton();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(text,"I am a JS Confirm");
    }

    @Test
    public void testSetInputInAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.clickPromptButton();
        String text = "TAU rocks!";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.alert_getResult(),"You entered: " + text);
    }
}
