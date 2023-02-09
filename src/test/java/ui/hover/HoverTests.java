package ui.hover;

import ui.base.BaseTests;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class HoverTests extends BaseTests {

    @Test
    void testHoverUser1(){
        var hoverPage = homePage.clickHovers();
        var caption = hoverPage.hoverOverFigure(1);
        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        assertEquals("name: user1", caption.getTitle(), "Not User1 title");
        assertEquals("View profile", caption.getLinkText(), "Cation link text not correct");
        assertTrue(caption.getLink().endsWith("/users/1"), "Not correct link");
    }
}
