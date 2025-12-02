// This class contains a test case that verifies the functionality of context clicking on the context menu page.

package actions;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ClickTests extends BaseTests {

    @Test
    public void testContextClick() {
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.contextClick();
        assertEquals(contextMenuPage.alert_getText(), "You selected a context menu");
        contextMenuPage.alert_clickToAccept();
    }
}
