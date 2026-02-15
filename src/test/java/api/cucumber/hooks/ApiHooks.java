package api.cucumber.hooks;

import api.cucumber.context.ApiScenarioContext;
import e2e.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class ApiHooks {

    @Before
    public void setUpApiBaseUri() {
        RestAssured.baseURI = ConfigReader.getRequired("apiBaseUrl");
    }

    @After
    public void clearScenarioContext() {
        ApiScenarioContext.clear();
    }
}
