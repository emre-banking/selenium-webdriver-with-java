// This class contains a test case that verifies the functionality of a horizontal slider.

package horizontalslider;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HorizontalSliderTests extends BaseTests {

    @Test
    public void testSlider(){
        // Click on the Horizontal Slider link in the home page and navigate to the Horizontal Slider page
        var sliderPage = homePage.clickHorizontalSlider();

        // Move the slider to the right by a specified value
        sliderPage.moveSliderRight(6);

        // Get the range value from the slider and verify that it matches the expected value
        assertEquals(sliderPage.getRange(), "3");
    }
}
