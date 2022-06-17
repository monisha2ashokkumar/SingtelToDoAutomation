package stepDefinitions;

import browser.BrowserActions;
import browser.WebDriverWaitActions;
import io.cucumber.java8.En;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pageObjects.ToDo;

public class ManageToDo implements En {

    public ManageToDo(){

        Given("Open the application", () -> {
            BrowserActions.getBrowser();
            WebDriverWaitActions.waitUntil(By.cssSelector("[class=new-todo"));
        });

        When("I enter {string} and press enter key", (String task) -> {
            ToDo.addNewToDo(task);
        });

        Then("Verify {string} is added to list", (String task) -> {
            Assert.assertTrue(ToDo.validateAddedTaskDisplayedInList(task));
        });
    }
}
