package framework.driver;

public enum BrowserType {
    CHROME,
    FIREFOX,
    EDGE;

    public static BrowserType from(String browser) {
        if (browser == null || browser.startsWith("${")) {
            return CHROME;
        }
        return BrowserType.valueOf(browser.toUpperCase());
    }
}
