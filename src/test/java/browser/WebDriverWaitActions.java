package browser;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WebDriverWaitActions {
    public static void waitUntil(By selector){
        BrowserActions.waitDriver().until(ExpectedConditions.visibilityOfElementLocated(selector));
    }
}
