package ui.keys;

import ui.base.BaseTests;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeysTests extends BaseTests {

    @Test
    void testBackspace(){
        var keyPage = homePage.clickKeyPresses();
        keyPage.enterText("A" + Keys.BACK_SPACE);
        assertEquals("You entered: BACK_SPACE", keyPage.getResult());
    }
}
