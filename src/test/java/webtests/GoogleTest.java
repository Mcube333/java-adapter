package webtests;

import core.base.BaseWebTest;
import core.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class GoogleTest extends BaseWebTest {

    @Test
    public void openGoogle() {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://www.google.com");
        System.out.println("Google Test Thread: " + Thread.currentThread().getName());

    }
}
