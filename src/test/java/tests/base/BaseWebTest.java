package tests.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import framework.driver.DriverFactory;
import framework.driver.DriverManager;

public class BaseWebTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quit();
    }
}
