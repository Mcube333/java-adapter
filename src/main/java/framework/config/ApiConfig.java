package framework.config;

public final class ApiConfig {

    private ApiConfig() {}

    public static String getBaseUrl() {
        return ConfigManager.get("api.base.url");
    }
}
