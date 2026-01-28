package tests.utils;

import com.aventstack.extentreports.ExtentTest;

import tests.listeners.ExtentTestListener;

public class ApiExtentLogger {

    public static void logRequest(String method, String url, String body) {
        ExtentTest test = ExtentTestListener.getTest();
        test.info("REQUEST");
        test.info("Method: " + method);
        test.info("URL: " + url);
        if (body != null) {
            test.info("Body: " + body);
        }
    }

    public static void logResponse(int statusCode, String response) {
        ExtentTest test = ExtentTestListener.getTest();
        test.info("RESPONSE");
        test.info("Status Code: " + statusCode);
        test.info("Body: " + response);
    }
}
