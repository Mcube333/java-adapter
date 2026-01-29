package tests.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import framework.config.ConfigManager;
import framework.driver.DriverFactory;
import framework.driver.DriverManager;

public abstract class BaseWebTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional String browser) {
        if (browser == null || browser.isEmpty()) {
            browser = System.getProperty(
                "browser",
                ConfigManager.get("browser")
            );
        }

        DriverFactory.initDriver(browser);
        DriverManager.getDriver()
            .get(ConfigManager.get("baseUrl"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
