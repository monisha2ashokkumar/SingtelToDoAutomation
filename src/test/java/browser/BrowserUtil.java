package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtil {
    public static WebDriver getBrowser() {

            switch (System.getProperty("browser") != null ? System.getProperty("browser") : "chrome") {
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    return new EdgeDriver();
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver();
                default:
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver();
            }

        }
}
