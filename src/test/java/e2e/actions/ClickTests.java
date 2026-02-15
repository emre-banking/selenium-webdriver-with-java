// This class contains a test case that verifies the functionality of context clicking on the context menu page.

package e2e.actions;

import e2e.base.BaseTests;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class ClickTests extends BaseTests {
    private static final String expectedAlertText = "You selected a context menu";

    @Description("Verify alert text after right-click context menu")
    @Test
    public void alertShouldShowCorrectMessageAfterRightClick() {
        // Given
        var contextMenuPage = homePage.navigateToContextMenu();

        // When
        contextMenuPage.openContextMenu();

        // Then
        contextMenuPage.verifyAlertText(expectedAlertText);
    }
}
