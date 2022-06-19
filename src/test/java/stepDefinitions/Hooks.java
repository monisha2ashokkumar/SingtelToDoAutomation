package stepDefinitions;

import browser.driver.DriverManager;
import utils.ConfigReader;
import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks implements En {

    public Hooks() {
        After((Scenario scenario) -> {
            // Take screenshot on fail and attach to report
            if (ConfigReader.getConfig().get("SCREENSHOT_ON_FAIL")
                    .equalsIgnoreCase("true") && scenario.isFailed()) {
                byte[] screenData = ((TakesScreenshot) DriverManager.driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenData, "image/png", "FailStepScreenshot");
            }
        });
    }
}
