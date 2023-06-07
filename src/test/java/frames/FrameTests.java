package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {

    @Test
    public void testTextEditor(){
        var editorPage = homePage.clickWYSIWYGEditor();
        editorPage.clearTextArea();
        editorPage.setTextArea("TAU rocks!");
        editorPage.clickDecreaseIndent();
        assertEquals(editorPage.getTextFromEditor(),"TAU rocks!");
    }
}
