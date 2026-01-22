package webtests;

import core.base.BaseWebTest;
import core.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class BingTest extends BaseWebTest {

    @Test
    public void openBing() {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://www.bing.com");
        System.out.println("Google Test Thread: " + Thread.currentThread().getName());

    }
}
