package framework.reporting;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentTestManager {

    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    private ExtentTestManager() {}

    public static void setTest(ExtentTest extentTest) {
        test.set(extentTest);
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void unload() {
        test.remove();
    }
}
