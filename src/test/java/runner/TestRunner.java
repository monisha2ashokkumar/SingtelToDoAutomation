package runner;

import browser.driver.DriverManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        plugin = {"html:src/reports/cucumber-reports.html", "rerun:src/reports/failedScenarios.txt",
        "pretty","json:src/reports/cucumber-reports.json"}
)
public class TestRunner {
    // Handling browser sessions on hooks for better control
    // To open the browser before start of all executions
    @BeforeClass
    public static void openBrowserSession() {
        DriverManager.getBrowser();
    }

    // To terminate the browser after all executions
    @AfterClass
    public static void closeBrowserSession() {
        DriverManager.closeSession();
    }
}
