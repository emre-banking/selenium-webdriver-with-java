package e2e.cucumber.steps;

import e2e.cucumber.CucumberTestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.JavaScriptAlertsPage;

import static org.testng.Assert.assertEquals;

public class JavaScriptAlertsSteps {

    private JavaScriptAlertsPage alertsPage;
    private String actualConfirmText;
    private String expectedConfirmText;

    @When("user accepts javascript alert")
    public void userAcceptsJavascriptAlert() {
        alertsPage = CucumberTestContext
                .getHomePage()
                .navigateToJavaScriptAlerts();

        alertsPage.clickAlertButton();
        alertsPage.acceptJavaScriptAlert();
    }

    @When("user dismisses javascript confirm with expected text {string}")
    public void userDismissesJavascriptConfirmWithExpectedText(String expectedText) {
        alertsPage = CucumberTestContext
                .getHomePage()
                .navigateToJavaScriptAlerts();

        alertsPage.clickConfirmButton();
        actualConfirmText = alertsPage.getAlertText();
        expectedConfirmText = expectedText;
        alertsPage.dismissJavaScriptAlert();
    }

    @Then("javascript confirm text should be verified")
    public void javascriptConfirmTextShouldBeVerified() {
        assertEquals(actualConfirmText, expectedConfirmText, "Alert text mismatch.");
    }

    @When("user accepts javascript prompt with input {string}")
    public void userAcceptsJavascriptPromptWithInput(String inputText) {
        alertsPage = CucumberTestContext
                .getHomePage()
                .navigateToJavaScriptAlerts();

        alertsPage.clickPromptButton();
        alertsPage.setAlertInputText(inputText);
        alertsPage.acceptJavaScriptAlert();
    }

    @Then("user should see alert result text {string}")
    public void userShouldSeeAlertResultText(String expectedText) {
        alertsPage.verifyResultText(expectedText);
    }
}
