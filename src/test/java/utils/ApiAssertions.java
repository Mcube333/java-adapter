package utils;

import io.restassured.response.Response;

public class ApiAssertions {

    public static void assertStatusCode(Response response, int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    public static void assertResponseNotNull(Response response) {
        if (response == null) {
            throw new AssertionError("API response is null");
        }
    }
}
