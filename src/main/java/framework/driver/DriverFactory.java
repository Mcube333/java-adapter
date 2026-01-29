package framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

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
                FirefoxOptions ffOptions = new FirefoxOptions();

                if (isCI()) {
                    ffOptions.addArguments("-headless");
                }

                return new FirefoxDriver(ffOptions);

            case EDGE:
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();

                if (isCI()) {
                    edgeOptions.addArguments("--headless=new");
                }

                return new EdgeDriver(edgeOptions);

            case CHROME:
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();

                if (isCI()) {
                    chromeOptions.addArguments(
                        "--headless=new",
                        "--no-sandbox",
                        "--disable-dev-shm-usage"
                    );
                }

                return new ChromeDriver(chromeOptions);
        }
    }

    private static boolean isCI() {
        return System.getenv("CI") != null;
    }
}
