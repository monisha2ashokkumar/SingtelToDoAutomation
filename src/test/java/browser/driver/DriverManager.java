package browser.driver;

import browser.BrowserUtil;
import utils.ConfigReader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverManager {
    public static WebDriver driver;

    public static WebDriver getBrowser() {

         // As part of the framework, to have a better control on browser sessions during individual test executions
         // such as from maven/test runner/editor.
         // If driver is not initiated earlier, initiate a new session; otherwise existing session will be returned

        if(driver==null){
            driver = BrowserUtil.getBrowser();
            driver.get(ConfigReader.getConfig().get("BASE_URI"));
            driver.manage().window().maximize();
            return driver;
        }else {
            return driver;
        }
    }

    public static WebDriverWait waitDriver() {
        long waitTime = Long.parseLong(ConfigReader.getConfig().get("WAIT_TIME_IN_SEC") != null ?
                ConfigReader.getConfig().get("WAIT_TIME_IN_SEC") : "20");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        return wait;
    }

    public static JavascriptExecutor getJavascriptExecutor() {
        return (JavascriptExecutor) driver;
    }

    public static void clearToDoFromLocalStorage() {
        getJavascriptExecutor().executeScript("window.localStorage.clear();");
    }

    public static void closeSession() {
        driver.close();
       // driver.quit();
    }
}
