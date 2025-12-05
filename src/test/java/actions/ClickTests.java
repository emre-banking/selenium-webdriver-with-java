// This class contains a test case that verifies the functionality of context clicking on the context menu page.

package actions;

import base.BaseTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class ClickTests extends BaseTests {
    private static final String expectedAlertText = "You selected a context menu";

    @Test
    public void alertShouldShowCorrectMessageAfterRightClick() {
        // Given
        var contextMenuPage = homePage.navigateToContextMenu();

        // When
        contextMenuPage.openContextMenu();

        // Then
        assertEquals(contextMenuPage.getAlertText(),
                expectedAlertText,
                "Alert text should match expected message");
        contextMenuPage.acceptAlert();
    }
}
