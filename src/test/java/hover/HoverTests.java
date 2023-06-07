// This class contains a test case that verifies the hover functionality on a user figure.

package hover;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HoverTests extends BaseTests {

    @Test
    public void testHoverUser1(){
        // Click on the Hovers link in the home page and navigate to the Hovers page
        var hoversPage = homePage.clickHovers();

        // Hover over the first user figure and retrieve the caption
        var caption = hoversPage.hoverOverFigure(1);

        // Verify that the caption is displayed
        assertTrue(caption.isCaptionDisplayed());

        // Verify the title of the caption
        assertEquals(caption.getTitle(), "name: user1");

        // Verify the link text of the caption
        assertEquals(caption.getLinkText(), "View profile");

        // Verify the link URL of the caption
        assertTrue(caption.getLink().endsWith("/users/1"));
    }
}
