package day23.StepDefinitions;

import day19.Selectors;
import day21.util.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericSteps extends BaseTest  {
    @Given("I navigate to website {string}")
    public void iNavigateToWebsite(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
        driver.get(url);
    }
    @And("I login using username:{word} and password {string}")
    public void iLoginUsingUsernameAndPassword(String username, String password) {
        driver.findElement(Selectors.username).sendKeys(username);
        driver.findElement(Selectors.password).sendKeys(password);
        driver.findElement(Selectors.loginButton).click();
        waitFor(ExpectedConditions.presenceOfElementLocated(Selectors.menu));
    }

    @Then("I should see success message {string}")
    public void iShouldSeeSuccessMessage(String message) {
        waitFor(ExpectedConditions.textToBePresentInElementLocated(Selectors.alert, message));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
