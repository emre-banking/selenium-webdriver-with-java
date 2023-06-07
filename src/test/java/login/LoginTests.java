// This package contains a test case for testing the login functionality.

package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccesfulLogin(){
        // Click on the Form Authentication link in the home page and navigate to the Login page
        LoginPage loginPage = homePage.clickFormAuthentication();

        // Enter the username and password
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");

        // Click the Login button and navigate to the Secure Area page
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();

        // Get the alert text from the Secure Area page and verify that it contains the expected message
        String actualResult = secureAreaPage.getAlertText();
        assertTrue(actualResult.contains("You logged into a secure area!"));
    }
}
