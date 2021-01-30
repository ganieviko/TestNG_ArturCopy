package day23.StepDefinitions;

import day19.Selectors;
import day21.util.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class SchoolDepartmentSteps extends BaseTest  {
    private WebDriver driver;
    private int numberOfRowsBeforeSave;
    private String randomName;
    private String randomCode;

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

    @And("I navigate to department creation menu")
    public void iNavigateToDepartmentCreationMenu() {
        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.setupMenu), "Setup Menu not visible");
        driver.findElement(Selectors.setupMenu).click();

        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.schoolSetupMenu), "School Setup Menu not visible");
        driver.findElement(Selectors.schoolSetupMenu).click();

        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.departmentMenu), "Department Menu not visible");
        driver.findElement(Selectors.departmentMenu).click();

        waitFor(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("toolbar h3"), "School Departments"), "We did not navigate to correct menu");
    }

    @When("I create department with name {string} and code {string}")
    public void iCreateDepartmentWithNameAndCode(String name, String code) {
        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.plusButton));
        driver.findElement(Selectors.plusButton).click();

        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.nameInput));
        driver.findElement(Selectors.nameInput).sendKeys(name); // TODO: random string

        waitFor(ExpectedConditions.presenceOfElementLocated(Selectors.codeInput));
        driver.findElement(Selectors.codeInput).sendKeys(code);

        numberOfRowsBeforeSave = driver.findElements(Selectors.departmentRows).size();
        driver.findElement(Selectors.saveButton).click();
    }

    @Then("I should see success message {string}")
    public void iShouldSeeSuccessMessage(String message) {
        waitFor(ExpectedConditions.textToBePresentInElementLocated(Selectors.alert, message));
    }

    @When("I delete the department with name {string} and code {string}")
    public void iDeleteTheDepartment(String departmentName, String departmentCode) {
        waitFor(ExpectedConditions.numberOfElementsToBeMoreThan(Selectors.departmentRows, numberOfRowsBeforeSave));
        List<WebElement> rows = driver.findElements(Selectors.departmentRows);
        boolean found = false;
        for (WebElement row : rows) {
            if (row.getText().contains(departmentName) && row.getText().contains(departmentCode)) {
                found = true;
                row.findElement(Selectors.trashButton).click();
            }
        }
        Assert.assertTrue(found, "The department was " + departmentName + "not found, after saving");

        wait.until(ExpectedConditions.presenceOfElementLocated(Selectors.confirmYes));
        driver.findElement(Selectors.confirmYes).click();
    }

    @When("I create department with random name and code")
    public void iCreateDepartmentWithRandomNameAndCode() {
        Random random = new Random();
        randomName = "random name " + random.nextInt();
        randomCode = "random code " + random.nextInt();

        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.plusButton));
        driver.findElement(Selectors.plusButton).click();

        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.nameInput));
        driver.findElement(Selectors.nameInput).sendKeys(randomName); // TODO: random string

        waitFor(ExpectedConditions.presenceOfElementLocated(Selectors.codeInput));
        driver.findElement(Selectors.codeInput).sendKeys(randomCode);

        numberOfRowsBeforeSave = driver.findElements(Selectors.departmentRows).size();
        driver.findElement(Selectors.saveButton).click();
    }

    @When("I delete the department with random name and code")
    public void iDeleteTheDepartmentWithRandomNameAndCode() {
        System.out.println("Deleting department " + randomName);
        waitFor(ExpectedConditions.numberOfElementsToBeMoreThan(Selectors.departmentRows, numberOfRowsBeforeSave));
        List<WebElement> rows = driver.findElements(Selectors.departmentRows);
        boolean found = false;
        for (WebElement row : rows) {
            if (row.getText().contains(randomName) && row.getText().contains(randomCode)) {
                found = true;
                row.findElement(Selectors.trashButton).click();
            }
        }
        Assert.assertTrue(found, "The department was " + randomName + "not found, after saving");

        wait.until(ExpectedConditions.presenceOfElementLocated(Selectors.confirmYes));
        driver.findElement(Selectors.confirmYes).click();
    }
}
