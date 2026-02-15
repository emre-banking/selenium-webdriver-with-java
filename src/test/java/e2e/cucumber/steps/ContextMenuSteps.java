package e2e.cucumber.steps;

import e2e.cucumber.CucumberTestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContextMenuPage;

public class ContextMenuSteps {

    private ContextMenuPage contextMenuPage;

    @When("user opens context menu area with right click")
    public void userOpensContextMenuAreaWithRightClick() {
        contextMenuPage = CucumberTestContext
                .getHomePage()
                .navigateToContextMenu();

        contextMenuPage.openContextMenu();
    }

    @Then("user should see context menu alert text {string}")
    public void userShouldSeeContextMenuAlertText(String expectedAlertText) {
        contextMenuPage.verifyAlertText(expectedAlertText);
    }
}
