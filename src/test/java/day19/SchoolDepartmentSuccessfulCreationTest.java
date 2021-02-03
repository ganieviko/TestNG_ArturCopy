package day19;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class SchoolDepartmentSuccessfulCreationTest {
    WebDriver driver;
    WebDriverWait wait;
    private String departmentName;
    private String departmentCode;
    private int numberOfRowsBeforeSave;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", StudentConstants.CHROME_DRIVER_PATH);
        driver = new ChromeDriver(); // TODO: parameterize browser
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);

        driver.get("https://test.campus.techno.study/"); // TODO: parameterize the website
        departmentName = "High School";
        departmentCode = "HS-1";
    }

    @Parameters({"username", "password"})
    @Test
    public void login(@Optional("daulet2030@gmail.com") String uname, @Optional("TechnoStudy123@") String upassword) {
        driver.findElement(Selectors.username).sendKeys(uname);
        driver.findElement(Selectors.password).sendKeys(upassword);
        driver.findElement(Selectors.loginButton).click();
        waitFor(ExpectedConditions.presenceOfElementLocated(Selectors.menu));
    }

    @Test(dependsOnMethods = "login")
    public void navigate() {
        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.setupMenu), "Setup Menu not visible");
        driver.findElement(Selectors.setupMenu).click();

        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.schoolSetupMenu), "School Setup Menu not visible");
        driver.findElement(Selectors.schoolSetupMenu).click();

        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.departmentMenu), "Department Menu not visible");
        driver.findElement(Selectors.departmentMenu).click();

        waitFor(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("toolbar h3"), "School Departments"), "We did not navigate to correct menu");
    }

    @Test(dependsOnMethods = "navigate")
    public void fillDepartmentInfo() {
        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.plusButton));
        driver.findElement(Selectors.plusButton).click();

        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.nameInput));
        driver.findElement(Selectors.nameInput).sendKeys(departmentName); // TODO: random string

        waitFor(ExpectedConditions.presenceOfElementLocated(Selectors.codeInput));
        driver.findElement(Selectors.codeInput).sendKeys(departmentCode);

        // TODO: validate that text was entered
    }

    @Test(dependsOnMethods = "fillDepartmentInfo")
    public void switchToSectionTab() {
        driver.findElement(Selectors.sectionTab).click();
        // TODO: validate that I am on section tab
    }

    @Test(dataProvider = "sections", dependsOnMethods = "switchToSectionTab")
    public void addSection(String name, String shortName) {
        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.plusButtonOverlay));
        driver.findElement(Selectors.plusButtonOverlay).click();
        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.nameInput));
        driver.findElement(Selectors.nameInput).sendKeys(name); // TODO: random string
        waitFor(ExpectedConditions.presenceOfElementLocated(Selectors.shortNameInput));
        driver.findElement(Selectors.shortNameInput).sendKeys(shortName);
        driver.findElement(Selectors.addSectionButton).click();

        List<WebElement> rows = driver.findElements(Selectors.sectionRows);
        boolean found = false;
        for (WebElement row : rows) {
            if (row.getText().contains(name) && row.getText().contains(shortName))
                found = true;
        }
        Assert.assertTrue(found, "The section was " + name + "not found, after adding");
    }

    @Test(dependsOnMethods = "addSection")
    public void savingTheDepartment() {
        numberOfRowsBeforeSave = driver.findElements(Selectors.browserTableRows).size();
        driver.findElement(Selectors.saveButton).click();
        waitFor(ExpectedConditions.textToBePresentInElementLocated(Selectors.alert, "School Department successfully created"));
    }

    @Test(dependsOnMethods = "savingTheDepartment")
    public void deleteDepartment() {
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

        waitFor(ExpectedConditions.textToBePresentInElementLocated(Selectors.alert, "School Department successfully deleted"));
    }

        @DataProvider(name="sections")
    public Object[][] sectionData() {
        String[][] testData = {
                {"Junior Classes", "Juniors"},
                {"Senior Classes", "Senior"}
        };
        return testData;
    }

    private <T> void waitFor(ExpectedCondition<T> condition) {
        waitFor(condition, condition.toString());
    }

    private <T> void waitFor(ExpectedCondition<T> condition, String errorMessage) {
        try {
            wait.until(condition);
        } catch (TimeoutException e) {
            Assert.fail(errorMessage);
        }
    }


}
