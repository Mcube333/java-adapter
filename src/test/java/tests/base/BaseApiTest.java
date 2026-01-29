package tests.base;

import framework.config.ApiConfig;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public abstract class BaseApiTest extends BaseTest {

    @BeforeClass(alwaysRun = true)
    public void setupApi() {
        RestAssured.baseURI = ApiConfig.getBaseUrl();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
