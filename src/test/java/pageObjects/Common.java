package pageObjects;

import browser.driver.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import service.ToDoService;

public class Common {
    public static void sendText(WebElement webElement, String task) {
        webElement.sendKeys(task);
    }

    public static void pressEnter(WebElement webElement, Keys keyIn) {
        webElement.sendKeys(keyIn);
    }

    public static void doubleClick(WebElement webElement){
        Actions actionDoubleClick = new Actions(DriverManager.driver);
        actionDoubleClick.doubleClick(webElement).perform();
    }

    public static void mouseHover(WebElement webElement){
        Actions actionMouseHover = new Actions(DriverManager.driver);
        actionMouseHover.moveToElement(webElement).perform();
    }

    public static void getAllLinks(){
        DriverManager.driver.findElements(By.cssSelector("a[href*=http]")).
                stream().map(el->el.getAttribute("href")).forEach(path-> Assert.assertEquals(200, ToDoService.validateResponseStatus(path)));

    }
}
