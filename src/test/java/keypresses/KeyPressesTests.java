// This package contains test cases for testing key presses functionality.

package keypresses;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class KeyPressesTests extends BaseTests {

    @Test
    public void verifyBackspaceKeyPressIsCaptured(){
        // Given
        var keyPressesPage = homePage.navigateToKeyPresses();

        // When
        keyPressesPage.enterText("A" + Keys.BACK_SPACE);

        // Then
        assertEquals(keyPressesPage.getResult(),
                "You entered: BACK_SPACE",
                "Backspace key press result mismatch.");
    }
}
