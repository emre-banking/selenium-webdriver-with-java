package api.cucumber.context;

import io.restassured.response.Response;

public final class ApiScenarioContext {

    private static final ThreadLocal<Response> LAST_RESPONSE = new ThreadLocal<>();

    private ApiScenarioContext() {
    }

    public static void setLastResponse(Response response) {
        LAST_RESPONSE.set(response);
    }

    public static Response getLastResponse() {
        Response response = LAST_RESPONSE.get();
        if (response == null) {
            throw new IllegalStateException("No API response is available in current scenario context.");
        }
        return response;
    }

    public static void clear() {
        LAST_RESPONSE.remove();
    }
}
