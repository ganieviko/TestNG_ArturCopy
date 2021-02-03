package day23.StepDefinitions;

import day19.Selectors;
import day21.util.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class SchoolLocationSteps extends BaseTest {

    @And("I navigate to school location creation menu")
    public void iNavigateToSchoolLocationCreationMenu() {
        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.setupMenu), "Setup Menu not visible");
        driver.findElement(Selectors.setupMenu).click();

        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.schoolSetupMenu), "School Setup Menu not visible");
        driver.findElement(Selectors.schoolSetupMenu).click();

        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.locationMenu), "Department Menu not visible");
        driver.findElement(Selectors.locationMenu).click();

        waitFor(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("toolbar h3"), "School Locations"), "We did not navigate to correct menu");
    }

    @When("I create school location with following data")
    public void iCreateSchoolLocationWithFollowingData(DataTable table) {
        Map<String, String> map = table.asMap(String.class, String.class);

        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.plusButton));
        driver.findElement(Selectors.plusButton).click();

        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.nameInput));
        driver.findElement(Selectors.nameInput).clear();
        driver.findElement(Selectors.nameInput).sendKeys(map.get("name"));

        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.shortNameInput));
        driver.findElement(Selectors.shortNameInput).clear();
        driver.findElement(Selectors.shortNameInput).sendKeys(map.get("shortName"));

        driver.findElement(By.cssSelector("mat-select[formcontrolname=\"type\"]")).click(); // clicking on select
        waitFor(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cdk-overlay-4"))); // waiting for popup
        driver.findElement(By.xpath("//*[@id='cdk-overlay-4']//span[contains(text(),'" +map.get("type")+ "')]")).click();

        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.capacityInput));
        driver.findElement(Selectors.capacityInput).clear();
        driver.findElement(Selectors.capacityInput).sendKeys(map.get("capacity"));

        driver.findElement(Selectors.saveButton).click();
    }

    @When("I delete the department with name {string}")
    public void iDeleteTheDepartmentWithName(String name) {
        waitForAngularStability(5);

        List<WebElement> rows = driver.findElements(Selectors.browserTableRows);
        boolean found = false;
        for (WebElement row : rows) {
            if (row.getText().contains(name)) {
                found = true;
                row.findElement(Selectors.trashButton).click();
            }
        }
        Assert.assertTrue(found, "The school location " + name + " was not found, after saving");

        wait.until(ExpectedConditions.presenceOfElementLocated(Selectors.confirmYes));
        driver.findElement(Selectors.confirmYes).click();
    }
}
