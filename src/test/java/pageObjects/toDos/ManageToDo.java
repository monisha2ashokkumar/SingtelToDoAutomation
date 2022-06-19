package pageObjects.toDos;


import browser.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageObjects.Common;

import java.util.List;
import java.util.stream.Collectors;

public class ManageToDo {
    private static final String addNew = "[class=new-todo]";
    private static final String toDoListTable = "ul[class=todo-list]";
    private static final String toDoListContent = "ul[class=todo-list] li label";

    public static boolean checkToDoTableAvailable(){
        return DriverManager.driver.findElements(By.cssSelector(toDoListContent)).size() != 0 ? true : false;
    }

    public static void addNewToDo(String task) {
        WebElement webElement = DriverManager.driver.findElement(By.cssSelector(addNew));
        Common.sendText(webElement, task);
        Common.pressEnter(webElement, Keys.ENTER);
    }

    public static boolean validateAddedTaskDisplayedInList(String task) {
        return validateTaskExists(task).size() != 0 ? true : false ;
    }

    public static boolean validateEmptyTaskNotAddedIntoList(String task) {
        //return false;
        return validateTaskExists(task).size() == 0 ? true : false ;
    }

    public static boolean validateToDoSectionExists() {
        List<WebElement> webElementList = DriverManager.driver.findElements(By.cssSelector("[class=main]"));
        return webElementList.size() == 0 ? true : false ;
    }
    public static List<WebElement> validateTaskExists(String task) {
        List<WebElement> lt = DriverManager.driver
                .findElements(By.cssSelector(toDoListContent))
                .stream().filter(x -> x.getText().equalsIgnoreCase(task.replaceAll("\\s+"," ")))
                .collect(Collectors.toList());
        return lt;
    }

    public static List<WebElement> validateAddedTasksCount() {
        List<WebElement> lt = DriverManager.driver.findElements(By.cssSelector(toDoListContent));
        return lt;
    }

    public static int validateItemsCount() {
        List<WebElement> lt = DriverManager.driver.findElements(By.cssSelector("[class=todo-count]"));
        return lt.size();
    }

    public static WebElement getToDoElementByName(String item){
        return DriverManager.driver.findElement(By.xpath("//*[contains(text(), '"+item+"')]/.."));
    }

    public static void locateAndUpdateToDo(String existingValue, String replaceWithNewValue) {
        WebElement webElement = getToDoElementByName(existingValue);
        Common.doubleClick(webElement);
        new Actions(DriverManager.driver)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(replaceWithNewValue + Keys.ENTER)
                .perform();
    }

    public static void deleteToDoItemByName(String item){
        WebElement todoItemElement = getToDoElementByName(item);
        Common.mouseHover(todoItemElement);
        todoItemElement.findElement(By.cssSelector("button")).click();
    }

}
