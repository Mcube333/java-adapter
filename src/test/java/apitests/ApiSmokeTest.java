package apitests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import core.base.BaseApiTest;
import utils.ApiAssertions;

import static io.restassured.RestAssured.given;

public class ApiSmokeTest extends BaseApiTest {

    @Test
    public void verifyUsersApi() {

        Response response =
            given()
                .header("Content-Type", "application/json")
            .when()
                .get("/users");

        ApiAssertions.assertResponseNotNull(response);
        ApiAssertions.assertStatusCode(response, 200);
    }
}
