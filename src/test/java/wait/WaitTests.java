// This package contains a test case for testing the wait functionality.

package wait;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTests {

    @Test
    public void verifyContentAppearsAfterLoadingDone(){
        // Given
        var loadingPage = homePage.navigateToDynamicLoading().navigateToExample1();

        // When
        loadingPage.clickStartButtonAndWait();

        // Then
        assertEquals(loadingPage.getLoadedText(),
                "Hello World!",
                "Loaded text mismatch.");
    }
}
