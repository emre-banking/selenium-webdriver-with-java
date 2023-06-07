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
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        String actualResult = secureAreaPage.getAlertText();
        assertTrue(actualResult.contains("You logged into a secure area!"));
    }
}
