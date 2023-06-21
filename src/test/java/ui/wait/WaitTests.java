package ui.wait;

import ui.base.BaseTests;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WaitTests extends BaseTests {

    @Test
    public void testWaitUntilHidden(){
        var loadingPage = homePage.clickDynamicLoading().clickExample1();
        loadingPage.clickStart();
        assertEquals("Hello World!", loadingPage.getLoadingText());
    }

    @Test
    public void testWaitUntilHidden2(){
        var loadingPage = homePage.clickDynamicLoading().clickExample1();
        loadingPage.clickStart();
        assertEquals("Hello World!!", loadingPage.getLoadingText());
    }
}
