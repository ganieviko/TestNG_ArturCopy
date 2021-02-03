package day21.util;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public <T> void waitFor(ExpectedCondition<T> condition) {
        waitFor(condition, condition.toString());
    }

    public <T> void waitFor(ExpectedCondition<T> condition, String errorMessage) {
        try {
            wait.until(condition);
        } catch (TimeoutException e) {
            Assert.fail(errorMessage);
        }
    }
}
