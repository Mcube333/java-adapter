package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {
        // Setup Chrome driver
        WebDriverManager.chromedriver().setup();

        // Enable headless mode for CI/CD
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");            // Run without GUI
        options.addArguments("--disable-gpu");         // Disable GPU acceleration
        options.addArguments("--window-size=1920,1080"); // Set default window size
        options.addArguments("--no-sandbox");          // Required for GitHub Actions
        options.addArguments("--disable-dev-shm-usage"); // Prevent memory issues in CI

        driver.set(new ChromeDriver(options));
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
