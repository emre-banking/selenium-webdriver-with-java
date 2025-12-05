// This class contains a test case that verifies the functionality of a horizontal slider.

package horizontalslider;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class HorizontalSliderTests extends BaseTests {

    @Test
    public void shouldMoveSliderToExpectedValue(){
        // Given
        var sliderPage = homePage.navigateToHorizontalSlider();

        // When
        sliderPage.moveSlider(
                Keys.ARROW_RIGHT,
                6
        );

        // Then
        assertEquals(sliderPage.getSliderValue(),
                "3",
                "Slider value mismatch.");
    }
}
