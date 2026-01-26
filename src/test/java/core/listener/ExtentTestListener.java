package core.listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import core.report.ExtentManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import core.utils.ScreenshotUtil;
import com.aventstack.extentreports.MediaEntityBuilder;



public class ExtentTestListener implements ITestListener {
	
	public static ExtentTest getTest() {
	    return test.get();
	}

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test.set(extent.createTest(result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

    	
        String screenshotPath =
                ScreenshotUtil.takeScreenshot(result.getMethod().getMethodName());

        if (screenshotPath != null) {
            test.get().fail(result.getThrowable(),
                    MediaEntityBuilder
                            .createScreenCaptureFromPath(screenshotPath)
                            .build());
        } else {
            test.get().fail(result.getThrowable());
            test.get().info("Retrying test if applicable...");
        }
    }


    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // 🔥 THIS CREATES THE FILE
    }
}
