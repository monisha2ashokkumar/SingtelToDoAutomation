package pageObjects;

import browser.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ToDo {
    private static final String addNew = "[class=new-todo]";
    private static final String toDoListTable = "[class=todo-list]";
    private static final String toDoListContent = "ul[class=todo-list] li label";

    public static void addNewToDo(String task) {
        WebElement webElement = BrowserActions.findElementAndScrollIntoView(By.cssSelector(addNew));
        sendText(webElement, task);
        pressEnter(webElement, Keys.ENTER);
    }

    public static void sendText(WebElement webElement, String task) {
        webElement.sendKeys(task);
    }

    public static void pressEnter(WebElement webElement, Keys keyIn) {
        webElement.sendKeys(keyIn);
    }

    public static boolean validateAddedTaskDisplayedInList(String task) {
        WebElement webElement = BrowserActions.findElementAndScrollIntoView(By.cssSelector(toDoListTable));
        return validateTaskExists(webElement, task).size()!=0 ? true : false ;
    }

    public static List<WebElement> validateTaskExists(WebElement webElement, String task) {
        List<WebElement> lt = webElement.findElements(By.cssSelector(toDoListContent))
                .stream().filter(x -> task.equalsIgnoreCase(x.getText())).collect(Collectors.toList());
        return lt;
    }
}
