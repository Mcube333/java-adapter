package api.client;

import core.config.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseApiClient {

    public BaseApiClient() {
        RestAssured.baseURI = ApiConfig.getBaseUrl();
    }

    public Response get(String endpoint) {
        return RestAssured.get(endpoint);
    }
}
