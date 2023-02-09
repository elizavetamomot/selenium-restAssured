package ui.alerts;

import ui.base.BaseTests;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    void testUploadFile(){
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("D:\\Users\\moeli\\IdeaProjects\\selenium-tut\\resources\\главная.gif");
        assertEquals("главная.gif", uploadPage.getUploadedFiles());
    }
}
