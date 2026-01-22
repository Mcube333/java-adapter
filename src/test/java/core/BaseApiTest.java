package core;

import config.ConfigManager;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = ConfigManager.getBaseApiUrl();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
