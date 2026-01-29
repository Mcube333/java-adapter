package framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {

    private DriverFactory() {}

    public static void initDriver(String browser) {
        BrowserType browserType = BrowserType.from(browser);
        WebDriver driver = createDriver(browserType);
        DriverManager.setDriver(driver);
    }

    private static WebDriver createDriver(BrowserType browserType) {
        switch (browserType) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            case EDGE:
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();

            case CHROME:
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }
    }
}
