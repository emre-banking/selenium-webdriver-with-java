// This class contains a test case that verifies the functionality of context clicking on the context menu page.

package actions;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ClickTests extends BaseTests {

    @Test
    public void testContextClick() throws InterruptedException {
        // Click on the Context Menu link in the home page and navigate to the Context Menu page
        var contextMenuPage = homePage.clickContextMenu();

        // Perform a context click action on the target element
        contextMenuPage.contextClick();

        // Verify the text of the alert dialog and accept it
        assertEquals(contextMenuPage.alert_getText(), "You selected a context menu");
        contextMenuPage.alert_clickToAccept();
    }
}
