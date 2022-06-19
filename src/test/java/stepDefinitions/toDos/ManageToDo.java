package stepDefinitions.toDos;

import io.cucumber.java8.En;
import org.junit.Assert;
import io.cucumber.datatable.DataTable;
import pageObjects.toDos.ManageFilters;

public class ManageToDo implements En {
    int totalCount;

    public ManageToDo(){

        When("I add a {string}", (String task) -> pageObjects.toDos.ManageToDo.addNewToDo(task));

        Then("Verify {string} is added to list", (String task) -> pageObjects.toDos.ManageToDo.validateAddedTaskDisplayedInList(task));

        Then("Verify space is not added to list", () -> pageObjects.toDos.ManageToDo.validateToDoSectionExists());

        Then("Validate items count matches with {int}", (Integer count) -> Assert.assertTrue(count== ManageFilters.getItemLeft()));

        Then("Validate displayed todo is same as {string} in web page", (String task) -> pageObjects.toDos.ManageToDo.validateTaskExists(task));

        When("I replace {string} with {string}",
                (String existingValue, String replaceWithNewValue) -> pageObjects.toDos.ManageToDo.locateAndUpdateToDo(existingValue, replaceWithNewValue));

        Then("Verify {string} is available in todo list", (String updatedValue) -> pageObjects.toDos.ManageToDo.validateAddedTaskDisplayedInList(updatedValue));

        Then("Verify {string} is removed from the todo list", (String oldValue) -> pageObjects.toDos.ManageToDo.validateEmptyTaskNotAddedIntoList(oldValue));

        When("I locate {string} and click on delete", (String item) -> pageObjects.toDos.ManageToDo.deleteToDoItemByName(item));

        Then("I store items left count", () -> totalCount = ManageFilters.getItemLeft());

        When("I check on {string}", (String item) -> ManageFilters.checkOrUncheckToDoItemByName(item));

        Then("Verify items left is reduced by {int}", (Integer count) -> {
            Assert.assertEquals(totalCount - count, ManageFilters.getItemLeft());
        });

        When("I add multiple todos", (DataTable dataTable) -> {
             dataTable.asList().forEach(item -> pageObjects.toDos.ManageToDo.addNewToDo(item));
        });

        Then("I check on multiple", (DataTable dataTable) -> {
            dataTable.asList().forEach(item -> ManageFilters.checkOrUncheckToDoItemByName(item));
        });

        Then("Verify multiple todos are removed from the todo list", (DataTable dataTable) -> {
            dataTable.asList().forEach(item -> pageObjects.toDos.ManageToDo.validateEmptyTaskNotAddedIntoList(item));
        });
    }
}
