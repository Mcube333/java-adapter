package core.listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import core.driver.DriverManager;

import core.report.ExtentManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

import java.io.File;
import java.nio.file.Files;

public class ExtentTestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test.set(extent.createTest(result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());

        // Screenshot only for Web tests
        if (DriverManager.getDriver() != null) {
            try {
            	File src = ((TakesScreenshot) DriverManager.getDriver())
                        .getScreenshotAs(OutputType.FILE);

                File dest = new File("target/screenshots/"
                        + result.getMethod().getMethodName() + ".png");

                dest.getParentFile().mkdirs();
                Files.copy(src.toPath(), dest.toPath());

                test.get().addScreenCaptureFromPath(dest.getPath());

            } catch (Exception e) {
                test.get().warning("Screenshot capture failed");
            }
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
