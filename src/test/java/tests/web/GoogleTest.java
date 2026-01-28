package tests.web;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import framework.driver.DriverManager;
import tests.base.BaseWebTest;

public class GoogleTest extends BaseWebTest {

    @Test
    public void openGoogle() {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://www.google.com");
        System.out.println("Google Test Thread: " + Thread.currentThread().getName());
//        assertTrue(false, "Intentional failure to validate screenshot");

    }
}
