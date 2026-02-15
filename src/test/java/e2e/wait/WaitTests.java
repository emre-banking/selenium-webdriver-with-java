// This package contains a test case for testing the wait functionality.

package e2e.wait;

import e2e.base.BaseTests;
import org.testng.annotations.Test;

public class WaitTests extends BaseTests {

    @Test
    public void verifyContentAppearsAfterLoadingDone(){
        // Given
        var loadingPage = homePage.navigateToDynamicLoading().navigateToExample1();

        // When
        loadingPage.clickStartButtonAndWait();

        // Then
        loadingPage.assertLoadedText("Hello World!");
    }
}
