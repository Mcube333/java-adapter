package tests.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import framework.config.ConfigManager;
import framework.driver.DriverFactory;
import framework.driver.DriverManager;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        String browser = System.getProperty("browser");
        if (browser == null || browser.startsWith("${")) {
            browser = ConfigManager.get("browser");
        }
        DriverFactory.initDriver(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}

