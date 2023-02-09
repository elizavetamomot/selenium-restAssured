package ui.dropdown;

import ui.base.BaseTests;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DropdownTest extends BaseTests {

    @Test
    public void testSelectOption(){
        var dropdownPage = homePage.clickDropdown();

        String option = "Option 1";
        dropdownPage.selectFromDropdown(option);
        var selectedOptions = dropdownPage.getSelectedOption();
        assertEquals(selectedOptions.size(), 1, "Incorrect number");
        assertTrue(selectedOptions.contains(option), "Option not selected");
    }
}
