// This package contains a test case for testing the login functionality.

package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    public void verifySuccessfulLogin(){
        // Given
        LoginPage loginPage = homePage.navigateToFormAuthentication();

        // When
        SecureAreaPage secureAreaPage =
                loginPage.login(
                "tomsmith",
                "SuperSecretPassword!"
        );

        // Then
        String actualResult = secureAreaPage.getAlertText();
        assertTrue(actualResult.contains(
                "You logged into a secure area!"),
                "Login failed.");
    }
}
