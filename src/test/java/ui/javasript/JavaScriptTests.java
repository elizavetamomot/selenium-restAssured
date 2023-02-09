package ui.javasript;

import ui.base.BaseTests;
import org.junit.jupiter.api.Test;

public class JavaScriptTests extends BaseTests {

    @Test
    void testScrollToTable(){
        homePage.clickLargeAndDeepDom().scrollToTable();
    }

    @Test
    void testScrollToFifthParagraphs(){
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }
}
