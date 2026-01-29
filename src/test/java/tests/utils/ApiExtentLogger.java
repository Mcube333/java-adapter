package tests.utils;

import framework.reporting.ExtentTestManager;

public final class ApiExtentLogger {

    private ApiExtentLogger() {}

    public static void logRequest(String method, String endpoint, String body) {
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest()
                .info(method + " " + endpoint);
        }
    }

    public static void logResponse(int status, String response) {
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest()
                .info("Status: " + status + "\n" + response);
        }
    }
}
