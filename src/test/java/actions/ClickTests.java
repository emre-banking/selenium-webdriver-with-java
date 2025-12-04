// This class contains a test case that verifies the functionality of context clicking on the context menu page.

package actions;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ClickTests extends BaseTests {

    @Test
    public void alertAppearsAfterContextClick() {
        var contextMenuPage = homePage.navigateToContextMenu();
        contextMenuPage.contextClick();
        assertEquals(contextMenuPage.getAlertText(), "You selected a context menu");
        contextMenuPage.acceptAlert();
    }
}
