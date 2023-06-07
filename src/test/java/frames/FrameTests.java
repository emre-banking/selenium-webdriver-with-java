// This class contains a test case that verifies the functionality of a text editor within a frame.

package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {

    @Test
    public void testTextEditor(){
        // Click on the WYSIWYG Editor link in the home page and navigate to the WYSIWYG Editor page
        var editorPage = homePage.clickWYSIWYGEditor();

        // Clear the text area in the editor, set new text, and click the "Decrease Indent" button
        editorPage.clearTextArea();
        editorPage.setTextArea("TAU rocks!");
        editorPage.clickDecreaseIndent();

        // Get the text from the editor and verify that it matches the expected text
        assertEquals(editorPage.getTextFromEditor(), "TAU rocks!");
    }
}
