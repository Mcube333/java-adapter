package tests.api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import tests.base.BaseApiTest;
import tests.utils.ApiExtentLogger;

public class ApiSmokeTest extends BaseApiTest {

	@Test(groups = {"api", "sanity", "regression"})
    public void verifyUsersApi() {

    	Response response =
    	        given()
    	        .when()
    	        .get("/users?page=2");

    	ApiExtentLogger.logRequest("GET", "/users?page=2", null);
    	ApiExtentLogger.logResponse(response.getStatusCode(), response.asPrettyString());

    	response.then().statusCode(200);
    }
}
