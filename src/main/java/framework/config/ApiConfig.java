package framework.config;

public class ApiConfig {

    public static String getBaseUrl() {
        String url = ConfigManager.get("base.api.url");
        if (url == null) {
            throw new RuntimeException("API Base URL is not configured");
        }
        return url;
    }
}
