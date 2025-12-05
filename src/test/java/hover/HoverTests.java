// This class contains a test case that verifies the hover functionality on a user figure.

package hover;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HoverTests extends BaseTests {

    @Test
    public void verifyUser1CaptionOnHover(){
        // Given
        var hoversPage = homePage.navigateToHovers();

        // When
        var caption = hoversPage.hoverOverFigure(1);

        // Then
        assertTrue(caption.isCaptionDisplayed(), "Caption is not displayed.");
        assertEquals(caption.getTitle(), "name: user1", "Caption title mismatch.");
        assertEquals(caption.getLinkText(), "View profile", "Caption link text mismatch.");
        assertTrue(caption.getLink().endsWith("/users/1"), "Caption link URL is incorrect.");
    }
}
