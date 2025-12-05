// This class contains a test case that verifies the functionality of selecting an option from a dropdown menu.

package dropdown;

import base.BaseTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class DropdownTests extends BaseTests {

    @Test
    public void verifyDropdownOptionSelection(){
        // Given
        var dropdownPage = homePage.navigateToDropdown();

        // When
        final String option = "Option 1";
        dropdownPage.selectFromDropdown(option);
        var selectedOptions = dropdownPage.getSelectedOptions();

        // Then
        assertEquals(selectedOptions.size(),
                1,
                "Only one option should be selected.");

        assertTrue(selectedOptions.contains(option),
                "Selected option mismatch.");
    }
}
