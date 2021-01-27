package day21.pom;

import day19.Selectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DepartmentFormPOM extends BasePom {
    private WebDriver driver;

    @FindBy(css="ms-table-toolbar > div ms-add-button")
    private WebElement plusButton;

    @FindBy(css="[placeholder='GENERAL.FIELD.NAME']>input")
    private WebElement nameInput;
    @FindBy(css="[placeholder='GENERAL.FIELD.CODE']>input")
    private WebElement codeInput;

    public DepartmentFormPOM(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);

        PageFactory.initElements(driver, this);
    }

    public void addNew() {
        waitFor(ExpectedConditions.visibilityOf(plusButton));
        plusButton.click();
    }

    public void fillInName(String departmentName) {
        waitFor(ExpectedConditions.visibilityOf(nameInput));
        nameInput.clear();
        nameInput.sendKeys(departmentName);
    }

    public String getDepNameInputValue() {
        return nameInput.getAttribute("value");
    }

    public void fillInCode(String departmentCode) {
        waitFor(ExpectedConditions.visibilityOf(codeInput));
        codeInput.clear();
        codeInput.sendKeys(departmentCode);
    }

    public String getDepCodeInputValue() {
        return codeInput.getAttribute("value");
    }
}
