package ui.frames;

import ui.base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FrameTests extends BaseTests {

    @Test
    void  testWysiwyg(){
        var editorPage = homePage.clickWysiwygEditor();
        editorPage.clearTextArea();

        String text1 = "hello ";
        String text2 = "world!";

        editorPage.setTextArea(text1);
        editorPage.decreaseIndention();
        editorPage.setTextArea(text2);
        Assertions.assertEquals(text1+text2, editorPage.getTextFromEditor());
    }
}
