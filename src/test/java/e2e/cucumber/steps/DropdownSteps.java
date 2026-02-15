package e2e.cucumber.steps;

import e2e.cucumber.CucumberTestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DropdownPage;

import java.util.List;

public class DropdownSteps {

    private DropdownPage dropdownPage;
    private List<String> selectedOptions;

    @When("user selects dropdown option {string}")
    public void userSelectsDropdownOption(String option) {
        dropdownPage = CucumberTestContext
                .getHomePage()
                .navigateToDropdown();

        dropdownPage.selectFromDropdown(option);
        selectedOptions = dropdownPage.getSelectedOptions();
    }

    @Then("only one dropdown option should be selected")
    public void onlyOneDropdownOptionShouldBeSelected() {
        dropdownPage.assertOnlyOneOptionSelected(selectedOptions);
    }

    @Then("selected dropdown option should be {string}")
    public void selectedDropdownOptionShouldBe(String expectedOption) {
        dropdownPage.assertOptionIsSelected(selectedOptions, expectedOption);
    }
}
