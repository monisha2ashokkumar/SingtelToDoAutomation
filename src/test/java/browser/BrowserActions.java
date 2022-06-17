package browser;

import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserActions {
    public static WebDriver driver;

    public static WebDriver getBrowser() {
        switch (System.getProperty("browser") != null ? System.getProperty("browser") : "chrome") {
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
        driver.get(ConfigReader.getConfig().get("BASE_URI"));
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriverWait waitDriver() {
        long waitTime = Long.parseLong(ConfigReader.getConfig().get("WAIT_TIME_IN_SEC") != null ?
                ConfigReader.getConfig().get("WAIT_TIME_IN_SEC") : "15");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        return wait;
    }

    public static JavascriptExecutor getJavascriptExecutor(){
        return (JavascriptExecutor) driver;
    }

    public static void scrollIntoView(WebElement webElement) {
        getJavascriptExecutor().executeScript("arguments[0].scrollIntoView();",
                webElement);
    }

    public static WebElement findElementAndScrollIntoView(By selector){
        WebElement webElement = driver.findElement(selector);
        scrollIntoView(webElement);
        return webElement;
    }

    public static void closeSession() {
        driver.close();
        driver.quit();
    }

}
