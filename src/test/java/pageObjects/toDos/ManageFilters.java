package pageObjects.toDos;

import browser.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.Common;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ManageFilters {

    public static void checkOrUncheckToDoItemByName(String item){
        WebElement todoItemElement = ManageToDo.getToDoElementByName(item);
        Common.mouseHover(todoItemElement);
        todoItemElement.findElement(By.cssSelector("input[type=checkbox]")).click();

    }

    public static int getItemLeft(){
        try{
            return Integer.parseInt(
                    DriverManager.driver
                            .findElement(By.cssSelector("[class=todo-count]"))
                            .getText()
                            .split(" item")[0]
            );
        }catch (NoSuchElementException e){
            return 0;
        }
    }

    public static boolean validateToDoItemStatus(String item, String status){
        String selector = status.equalsIgnoreCase("completed")? "[class='todo completed']" : "[class=todo]";
        List<WebElement> completedToDoList = DriverManager.driver.findElements(By.cssSelector(selector));
        List<WebElement> lt = completedToDoList.stream().filter(x->(
                x.getText().equalsIgnoreCase(item)
                )).collect(Collectors.toList());
        return lt.size()!=0 ? true : false;
    }

    public static void clickOnFilterBy(String status){
        DriverManager.driver.findElement(By.cssSelector("a[href*="+status+"]")).click();
    }

    public static void clickOnClearCompleted(){
        DriverManager.driver.findElement(By.cssSelector("button[class='clear-completed']")).click();
    }

    public static void clickOnToggleAllCheckboc(){
        DriverManager.driver.findElement(By.cssSelector("[for='toggle-all']")).click();
    }
}
