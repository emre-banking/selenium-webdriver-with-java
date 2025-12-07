// This package contains test cases for testing key presses functionality.

package e2e.keypresses;

import e2e.base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class KeyPressesTests extends BaseTests {

    @Test
    public void verifyBackspaceKeyPressIsCaptured(){
        // Given
        var keyPressesPage = homePage.navigateToKeyPresses();

        // When
        keyPressesPage.enterText("A" + Keys.BACK_SPACE);

        // Then
        keyPressesPage.assertKeyPressResult("You entered: BACK_SPACE");
    }
}
