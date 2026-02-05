package tests.base;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import framework.config.ConfigManager;

public class BaseApiTest {

    @BeforeClass(alwaysRun = true)
    public void setupApi() {
        RestAssured.baseURI = ConfigManager.get("apiBaseUrl");
    }
}
