package horizontalslider;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HorizontalSliderTests extends BaseTests {

    @Test
    public void testSlider(){
        var sliderPage = homePage.clickHorizontalSlider();
        sliderPage.moveSliderRight(6);
        assertEquals(sliderPage.getRange(),"3");
    }
}
