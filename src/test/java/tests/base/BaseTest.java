package tests.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import framework.config.ConfigManager;
import framework.driver.DriverFactory;
import framework.driver.DriverManager;

public class BaseTest {

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void setUp(@Optional String browser) {
	    if (browser == null) {
	        browser = System.getProperty("browser", ConfigManager.get("browser"));
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

