package e2e.cucumber.steps;

import e2e.cucumber.CucumberTestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pages.KeyPressesPage;

public class KeyPressesSteps {

    private KeyPressesPage keyPressesPage;

    @When("user enters backspace key sequence in key presses input")
    public void userEntersBackspaceKeySequenceInKeyPressesInput() {
        keyPressesPage = CucumberTestContext
                .getHomePage()
                .navigateToKeyPresses();

        keyPressesPage.enterText("A" + Keys.BACK_SPACE);
    }

    @Then("key press result should be {string}")
    public void keyPressResultShouldBe(String expectedResult) {
        keyPressesPage.assertKeyPressResult(expectedResult);
    }
}
