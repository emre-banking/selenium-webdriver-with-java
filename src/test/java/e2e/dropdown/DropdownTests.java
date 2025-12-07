// This class contains a test case that verifies the functionality of selecting an option from a dropdown menu.

package e2e.dropdown;

import e2e.base.BaseTests;
import org.testng.annotations.Test;

public class DropdownTests extends BaseTests {
    final String option = java.util.List.of("Option 1", "Option 2")
            .get(new java.util.Random().nextInt(2));

    @Test
    public void verifyDropdownOptionSelection(){
        // Given
        var dropdownPage = homePage.navigateToDropdown();

        // When
        dropdownPage.selectFromDropdown(option);
        var selectedOptions = dropdownPage.getSelectedOptions();

        // Then
        dropdownPage.assertOnlyOneOptionSelected(selectedOptions);
        dropdownPage.assertOptionIsSelected(selectedOptions, option);
    }
}
