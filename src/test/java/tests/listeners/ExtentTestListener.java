package tests.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import framework.reporting.ExtentManager;
import framework.reporting.ExtentTestManager;

public class ExtentTestListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
	    ExtentTest test =
	        ExtentManager.getExtent()
	            .createTest(result.getMethod().getMethodName());

	    for (String group : result.getMethod().getGroups()) {
	        test.assignCategory(group);
	    }

	    ExtentTestManager.setTest(test);
	}


    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTestManager.getTest()
                .fail(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getExtent().flush();
    }
}
