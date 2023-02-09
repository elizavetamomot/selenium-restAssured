package ui.navigation;

import ui.base.BaseTests;
import org.junit.jupiter.api.Test;

public class NavigationTests extends BaseTests {

    @Test
    void testNavigator(){
        homePage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("http:\\google.ru");
    }

    @Test
    void testSwitchTab(){
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().switchToTab("New Window");
    }
}
