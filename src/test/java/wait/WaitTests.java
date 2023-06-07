// This package contains a test case for testing the wait functionality.

package wait;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTests {

    @Test
    public void testWaitUntilHidden(){
        // Click on the Dynamic Loading link in the home page and navigate to Example 1 page
        var loadingPage = homePage.clickDynamicLoading().clickExample1();

        // Click the Start button on the Example 1 page
        loadingPage.clickStartButton();

        // Wait until the loading spinner is hidden and verify the finish text
        assertEquals(loadingPage.getFinishText(), "Hello World!");
    }
}
