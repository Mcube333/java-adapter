package tests.base;

import java.lang.reflect.Method;
import org.testng.annotations.BeforeMethod;

import framework.config.ConfigManager;
import framework.driver.DriverManager;

public class BaseWebTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void openBaseUrl(Method method) {
        DriverManager.getDriver()
            .get(ConfigManager.get("baseUrl"));
    }
}
