package core.base;

import core.driver.DriverFactory;
import core.driver.DriverManager;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        DriverManager.setDriver(DriverFactory.createDriver());
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quit();
    }
}
