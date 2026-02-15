// This class contains a test case that verifies the functionality of a text editor within a frame.

package e2e.frames;

import e2e.base.BaseTests;
import org.testng.annotations.Test;

public class FrameTests extends BaseTests {

    @Test
    public void verifyTextEditor(){
        // Given
        var editorPage = homePage.navigateToWYSIWYGEditor();

        // Then
        editorPage.assertEditorIsReadOnly();
        editorPage.assertEditorText("Your content goes here.");
    }
}
