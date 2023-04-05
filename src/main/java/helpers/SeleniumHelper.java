package helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelper {
    public static WebElement waitClickable(WebElement element, WebDriverWait wait) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
