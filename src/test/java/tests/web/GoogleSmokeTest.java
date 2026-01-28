package tests.web;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import framework.driver.DriverManager;
import tests.base.BaseWebTest;

import static org.testng.Assert.assertTrue;

public class GoogleSmokeTest extends BaseWebTest {

    @Test
    public void verifyGoogleTitle() {

        WebDriver driver = DriverManager.getDriver();
        driver.get("https://www.google.com");

        assertTrue(driver.getTitle().contains("Google"),
                "Page title validation failed");
    }
}
