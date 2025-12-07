// This class contains a test case that verifies the functionality of a horizontal slider.

package e2e.horizontalslider;

import e2e.base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class HorizontalSliderTests extends BaseTests {

    @Test
    public void shouldMoveSliderToExpectedValue(){
        // Given
        var sliderPage = homePage.navigateToHorizontalSlider();

        // When
        sliderPage.moveSlider(Keys.ARROW_RIGHT, 6);

        // Then
        sliderPage.assertSliderValue("3");
    }
}
