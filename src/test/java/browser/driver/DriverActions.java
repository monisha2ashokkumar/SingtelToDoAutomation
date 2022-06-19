package browser.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DriverActions {
    public static void waitDriverUntil(By selector){
        DriverManager.waitDriver().until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public static void waitDriverUntil(WebElement webElement){
        DriverManager.waitDriver().until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void scrollIntoView(WebElement webElement) {
        DriverManager.getJavascriptExecutor().executeScript("arguments[0].scrollIntoView(true);",
                webElement);
    }

    public static WebElement findElementAndScrollIntoView(By selector){
        WebElement webElement = DriverManager.driver.findElement(selector);
        scrollIntoView(webElement);
        return webElement;
    }
}
