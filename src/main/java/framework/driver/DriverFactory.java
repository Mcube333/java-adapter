package framework.driver;

import framework.config.ConfigManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static void initDriver(String browser) {
        WebDriver driver = createDriver(browser);
        DriverManager.setDriver(driver);
    }

    private static WebDriver createDriver(String browser) {
        if (browser == null) {
            browser = ConfigManager.get("browser");
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            default:
                throw new IllegalArgumentException(
                    "Unsupported browser: " + browser
                );
        }
    }
}

