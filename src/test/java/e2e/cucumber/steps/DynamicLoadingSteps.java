package e2e.cucumber.steps;

import e2e.cucumber.CucumberTestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DynamicLoadingExample1Page;

public class DynamicLoadingSteps {

    private DynamicLoadingExample1Page loadingPage;

    @When("user starts dynamic loading example 1")
    public void userStartsDynamicLoadingExample1() {
        loadingPage = CucumberTestContext
                .getHomePage()
                .navigateToDynamicLoading()
                .navigateToExample1();

        loadingPage.clickStartButtonAndWait();
    }

    @Then("loaded text should be {string}")
    public void loadedTextShouldBe(String expectedText) {
        loadingPage.assertLoadedText(expectedText);
    }
}
