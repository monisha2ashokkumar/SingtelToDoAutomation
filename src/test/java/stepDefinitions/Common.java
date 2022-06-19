package stepDefinitions;

import browser.driver.DriverActions;
import browser.driver.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.openqa.selenium.By;
import pageObjects.toDos.ManageFilters;
import pageObjects.toDos.ManageToDo;

public class Common implements En {

    public Common() {

        Given("Open the application", () -> {
            DriverManager.getBrowser();
            DriverActions.waitDriverUntil(By.cssSelector("[class=new-todo"));
        });

        Given("I clear all existing todos", () -> {
            DriverManager.clearToDoFromLocalStorage();
            DriverManager.driver.navigate().refresh();
        });

        When("I click on Clear Completed button", ManageFilters::clickOnClearCompleted);

        When("I click on all toggle checkbox", ManageFilters::clickOnToggleAllCheckboc);

        Then("I should see all todos are displayed", (DataTable dataTable) -> dataTable.asList().forEach(ManageToDo::validateTaskExists));

        Then("Verify there is no broken links", pageObjects.Common::getAllLinks);

        When("I click on refresh", () -> DriverManager.driver.navigate().refresh());

        Then("I close the browser", DriverManager::closeSession);
    }
}
