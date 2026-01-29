package tests.base;

import framework.config.ApiConfig;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseApiTest extends BaseTest {

	@BeforeClass
	public void setup() {
	    RestAssured.baseURI = ApiConfig.getBaseUrl();
	}
}
