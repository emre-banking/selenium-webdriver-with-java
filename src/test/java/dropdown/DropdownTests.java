// This class contains a test case that verifies the functionality of selecting an option from a dropdown menu.

package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DropdownPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTests extends BaseTests {

    @Test
    public void testSelectOption(){
        // Click on the Dropdown link in the home page and navigate to the Dropdown page
        var dropdownPage = homePage.clickDropdown();

        // Select an option from the dropdown
        String option = "Option 1";
        dropdownPage.selectFromDropdown(option);

        // Get the selected options from the dropdown
        var selectedOptions = dropdownPage.getSelectedOptions();

        // Verify that only one option is selected and it is the expected option
        assertEquals(selectedOptions.size(), 1);
        assertTrue(selectedOptions.contains(option));
    }
}
