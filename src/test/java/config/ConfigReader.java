package config;

import io.github.cdimascio.dotenv.Dotenv;

public class ConfigReader {
    public static Dotenv getConfig() {
        Dotenv dotenv = Dotenv.configure().directory("propertyFiles").filename(
                (System.getProperty("env") == null ? "qa": System.getProperty("env"))+
                ".properties").load();
        return dotenv;
    }
}
