// This class contains a test case that verifies the functionality of a text editor within a frame.

package e2e.frames;

import e2e.base.BaseTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class FrameTests extends BaseTests {

    @Test
    public void verifyTextEditor(){
        // Given
        var editorPage = homePage.navigateToWYSIWYGEditor();

        // When
        editorPage.clearTextArea();
        editorPage.setTextArea("TAU rocks!");
        editorPage.clickDecreaseIndent();

        // Then
        editorPage.assertEditorText("TAU rocks!");
    }
}
