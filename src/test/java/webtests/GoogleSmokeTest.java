package webtests;

import core.BaseWebTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import driver.DriverFactory;

import static org.testng.Assert.assertTrue;

public class GoogleSmokeTest extends BaseWebTest {

    @Test
    public void verifyGoogleTitle() {

        WebDriver driver = DriverFactory.getDriver();
        driver.get("https://www.google.com");

        assertTrue(driver.getTitle().contains("Google"),
                "Page title validation failed");
    }
}
