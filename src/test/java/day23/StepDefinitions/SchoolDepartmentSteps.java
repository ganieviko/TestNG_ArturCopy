package day23.StepDefinitions;

import day19.Selectors;
import day21.util.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class SchoolDepartmentSteps extends BaseTest  {
    private int numberOfRowsBeforeSave;
    private String randomName;
    private String randomCode;

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
        driver.findElement(Selectors.nameInput).clear();
        driver.findElement(Selectors.nameInput).sendKeys(name);

        waitFor(ExpectedConditions.presenceOfElementLocated(Selectors.codeInput));
        driver.findElement(Selectors.codeInput).clear();
        driver.findElement(Selectors.codeInput).sendKeys(code);

        numberOfRowsBeforeSave = driver.findElements(Selectors.browserTableRows).size();
        driver.findElement(Selectors.saveButton).click();
    }

    @When("I delete the department with name {string} and code {string}")
    public void iDeleteTheDepartment(String departmentName, String departmentCode) {
        waitFor(ExpectedConditions.numberOfElementsToBeMoreThan(Selectors.browserTableRows, numberOfRowsBeforeSave));
        List<WebElement> rows = driver.findElements(Selectors.browserTableRows);
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

    @When("I create department with name random and code random")
    public void iCreateDepartmentWithRandomNameAndCode() {
        Random random = new Random();
        randomName = "random name " + random.nextInt();
        randomCode = "random code " + random.nextInt();

        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.plusButton));
        driver.findElement(Selectors.plusButton).click();

        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.nameInput));
        driver.findElement(Selectors.nameInput).clear();
        driver.findElement(Selectors.nameInput).sendKeys(randomName);

        waitFor(ExpectedConditions.presenceOfElementLocated(Selectors.codeInput));
        driver.findElement(Selectors.codeInput).clear();
        driver.findElement(Selectors.codeInput).sendKeys(randomCode);

        numberOfRowsBeforeSave = driver.findElements(Selectors.browserTableRows).size();
        driver.findElement(Selectors.saveButton).click();
    }

    @When("I delete the department with name random and code random")
    public void iDeleteTheDepartmentWithRandomNameAndCode() {
        System.out.println("Deleting department " + randomName);
        waitFor(ExpectedConditions.numberOfElementsToBeMoreThan(Selectors.browserTableRows, numberOfRowsBeforeSave));
        List<WebElement> rows = driver.findElements(Selectors.browserTableRows);
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

    @When("I create department with name {string} and code {string} without saving")
    public void iCreateDepartmentWithNameAndCodeWithoutSaving(String name, String code) {
        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.plusButton));
        driver.findElement(Selectors.plusButton).click();

        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.nameInput));
        driver.findElement(Selectors.nameInput).clear();
        driver.findElement(Selectors.nameInput).sendKeys(name);

        waitFor(ExpectedConditions.presenceOfElementLocated(Selectors.codeInput));
        driver.findElement(Selectors.codeInput).clear();
        driver.findElement(Selectors.codeInput).sendKeys(code);

        numberOfRowsBeforeSave = driver.findElements(Selectors.browserTableRows).size();
    }

    @And("I click on department save button")
    public void iClickOnDepartmentSaveButton() {
        driver.findElement(Selectors.saveButton).click();
    }


}
