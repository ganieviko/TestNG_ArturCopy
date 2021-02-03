package day23.StepDefinitions;

import day19.Selectors;
import day21.util.BaseTest;
import day23.model.DepartmentSection;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class DepartmentSectionSteps extends BaseTest {
    @And("I create following sections")
    public void iCreateFollowingSections(List<DepartmentSection> list) {
        for (DepartmentSection section : list) {
            driver.findElement(Selectors.sectionTab).click();
            waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.plusButtonOverlay));
            driver.findElement(Selectors.plusButtonOverlay).click();
            waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.nameInput));
            driver.findElement(Selectors.nameInput).clear();
            driver.findElement(Selectors.nameInput).sendKeys(section.getName());
            waitFor(ExpectedConditions.presenceOfElementLocated(Selectors.shortNameInput));
            driver.findElement(Selectors.shortNameInput).clear();
            driver.findElement(Selectors.shortNameInput).sendKeys(section.getShortName());
            driver.findElement(Selectors.addSectionButton).click();

            List<WebElement> rows = driver.findElements(Selectors.sectionRows);
            boolean found = false;
            for (WebElement row : rows) {
                if (row.getText().contains(section.getName()) && row.getText().contains(section.getShortName()))
                    found = true;
            }
            Assert.assertTrue(found, "The section was " + section.getName() + "not found, after adding");
        }
    }

    @DataTableType
    public DepartmentSection converter(Map<String, String> entry) {
//        return new DepartmentSection(entry.get("sectionName"), entry.get("sectionShortName"));
        DepartmentSection object = new DepartmentSection();
        object.setName(entry.get("sectionName"));
        object.setShortName(entry.get("sectionShortName"));
        return object;
    }

    @And("I create following section")
    public void iCreateFollowingSection(DataTable table) {
        Map<String, String> map = table.asMap(String.class, String.class);
        driver.findElement(Selectors.sectionTab).click();
        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.plusButtonOverlay));
        driver.findElement(Selectors.plusButtonOverlay).click();
        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.nameInput));
        driver.findElement(Selectors.nameInput).clear();
        driver.findElement(Selectors.nameInput).sendKeys(map.get("sectionName"));
        waitFor(ExpectedConditions.presenceOfElementLocated(Selectors.shortNameInput));
        driver.findElement(Selectors.shortNameInput).clear();
        driver.findElement(Selectors.shortNameInput).sendKeys(map.get("sectionShortName"));
        driver.findElement(Selectors.addSectionButton).click();

        List<WebElement> rows = driver.findElements(Selectors.sectionRows);
        boolean found = false;
        for (WebElement row : rows) {
            if (row.getText().contains(map.get("sectionName")) && row.getText().contains(map.get("sectionShortName")))
                found = true;
        }
        Assert.assertTrue(found, "The section was " + map.get("sectionName") + "not found, after adding");
    }
}
