// This class contains a test case that verifies the hover functionality on a user figure.

package e2e.hover;

import e2e.base.BaseTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class HoverTests extends BaseTests {

    @Test
    public void verifyUser1CaptionOnHover(){
        // Given
        var hoversPage = homePage.navigateToHovers();

        // When
        var caption = hoversPage.hoverOverFigure(1);

        // Then
        caption.assertCaption("name: user1", "View profile", "/users/1");
    }
}
