package day21.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

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

    public void waitForAngularStability(int seconds) {
        waitForAngularStability(seconds, "Waited " + seconds + " seconds for angular to be stable, but failed!");
    }
    public void waitForAngularStability(int seconds, String message) {
        try {
            ExpectedCondition<Boolean> angularLoad = driver -> Boolean.valueOf(((JavascriptExecutor) driver)
                    .executeScript("return window.getAllAngularTestabilities().findIndex(x=>!x.isStable()) === -1").toString());
            wait.withTimeout(Duration.of(seconds, ChronoUnit.SECONDS)).until(angularLoad);
        } catch (TimeoutException e) {
            Assert.fail(message, e);
        }
    }
}
