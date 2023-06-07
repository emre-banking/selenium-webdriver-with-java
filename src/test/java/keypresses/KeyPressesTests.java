// This package contains test cases for testing key presses functionality.

package keypresses;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class KeyPressesTests extends BaseTests {

    @Test
    public void testBackSpace(){
        // Click on the Key Presses link in the home page and navigate to the Key Presses page
        var keyPressesPage = homePage.clickKeyPresses();

        // Enter the text "A" followed by the BACK_SPACE key
        keyPressesPage.enterText("A" + Keys.BACK_SPACE);

        // Verify that the result text matches the expected value
        assertEquals(keyPressesPage.getResult(), "You entered: BACK_SPACE");
    }

    @Test
    public void testPi(){
        // Click on the Key Presses link in the home page and navigate to the Key Presses page
        var keyPressesPage = homePage.clickKeyPresses();

        // Enter the Pi value using a keyboard shortcut
        keyPressesPage.enterPi();
    }
}
