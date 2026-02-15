package api.cucumber.steps;

import api.client.BaseApiClient;
import api.cucumber.context.ApiScenarioContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class CommonApiSteps {

    private final BaseApiClient apiClient = new BaseApiClient();

    @When("user sends GET request to {string}")
    public void userSendsGetRequestTo(String path) {
        Response response = apiClient.get(path);
        ApiScenarioContext.setLastResponse(response);
    }

    @Then("api response status code should be {int}")
    public void apiResponseStatusCodeShouldBe(int expectedStatusCode) {
        int actualStatusCode = ApiScenarioContext.getLastResponse().statusCode();
        assertEquals(actualStatusCode, expectedStatusCode, "Unexpected status code.");
    }
}
