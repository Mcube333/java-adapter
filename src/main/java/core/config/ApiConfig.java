package core.config;

public class ApiConfig {

    public static String getBaseUrl() {
        String url = ConfigManager.get("apiBaseUrl");
        System.out.println("API Base URL Loaded: " + url);
        return url;
    }
}
