package tests.base;

import org.testng.annotations.BeforeMethod;

import framework.config.ConfigManager;
import framework.driver.DriverManager;

public class BaseWebTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void openBaseUrl() {
        DriverManager.getDriver()
            .get(ConfigManager.get("baseUrl"));
    }
}

