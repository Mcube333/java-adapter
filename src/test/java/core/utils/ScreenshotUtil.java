package core.utils;

import core.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotUtil {

    public static String takeScreenshot(String testName) {

        WebDriver driver = DriverManager.getDriver();
        if (driver == null) {
            return null;
        }

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String screenshotDir = "test-output/screenshots";
        String screenshotPath = screenshotDir + "/" + testName + ".png";

        try {
            Path path = Paths.get(screenshotDir);
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
            Files.copy(source.toPath(), Paths.get(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }
}
