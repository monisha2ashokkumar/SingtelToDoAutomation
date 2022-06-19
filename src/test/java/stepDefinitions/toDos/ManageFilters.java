package stepDefinitions.toDos;

import io.cucumber.java8.En;
import org.junit.Assert;

public class ManageFilters implements En {

    public ManageFilters() {
        When("I toggle {string}", (String toggletype) -> {
            boolean toggle = Boolean.parseBoolean(toggletype);
            if(toggle) pageObjects.toDos.ManageFilters.clickOnToggleAllCheckboc();
        });

        When("I click on {string}", (String filter) -> pageObjects.toDos.ManageFilters.clickOnFilterBy(filter));

        Then("Verify {string} is in {string} status", (String item, String status) -> {
            Assert.assertTrue(pageObjects.toDos.ManageFilters.validateToDoItemStatus(item, status));
        });
    }
}
