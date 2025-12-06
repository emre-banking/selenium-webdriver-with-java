// This package contains a test case for testing the login functionality.

package e2e.login;

import e2e.base.BaseTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;
import e2e.utils.ConfigReader;

import static org.testng.Assert.assertTrue;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class LoginTests extends BaseTests {

    @Test
    public void verifySuccessfulLogin(){
        // Given
        LoginPage loginPage = homePage.navigateToFormAuthentication();

        // When
        SecureAreaPage secureAreaPage = loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );

        // Then
        String actualResult = secureAreaPage.getAlertText();
        assertTrue(actualResult.contains("You logged into a secure area!"), "Login failed.");
    }
}
