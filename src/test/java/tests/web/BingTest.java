package tests.web;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import framework.driver.DriverManager;
import tests.base.BaseWebTest;

public class BingTest extends BaseWebTest {

    @Test
    public void openBing() {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://www.bing.com");
        System.out.println("Google Test Thread: " + Thread.currentThread().getName());

    }
}
