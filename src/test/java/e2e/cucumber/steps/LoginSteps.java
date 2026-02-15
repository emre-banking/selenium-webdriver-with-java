package e2e.cucumber.steps;

import e2e.cucumber.CucumberTestContext;
import e2e.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginSteps {

    private LoginPage loginPage;
    private SecureAreaPage secureAreaPage;

    @Given("user is on home page")
    public void userIsOnHomePage() {
        CucumberTestContext.getHomePage();
    }

    @When("user logs in with valid credentials")
    public void userLogsInWithValidCredentials() {
        loginPage = CucumberTestContext
                .getHomePage()
                .navigateToFormAuthentication();

        secureAreaPage = loginPage.login(
                ConfigReader.getRequired("username"),
                ConfigReader.getRequired("password")
        );
    }

    @Then("user should see secure area success message")
    public void userShouldSeeSecureAreaSuccessMessage() {
        String loginMessage = secureAreaPage.getAlertText();
        loginPage.assertLoginSuccess(loginMessage);
    }
}
