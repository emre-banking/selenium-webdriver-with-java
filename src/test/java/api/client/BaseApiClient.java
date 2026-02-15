package api.client;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseApiClient {

    public Response get(String path) {
        return given()
                .header("Accept", "application/json")
                .when()
                .get(path)
                .then()
                .extract()
                .response();
    }
}
