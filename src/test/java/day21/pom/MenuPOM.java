package day21.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPOM extends BasePom {
    private WebDriver driver;

    @FindBy(css=".group-items > :nth-child(1)")
    private WebElement setupMenu;
    @FindBy(css=".group-items > :nth-child(1) fuse-nav-vertical-collapsable:nth-child(2)")
    private WebElement schoolSetupMenu;
    @FindBy(css=".group-items > :nth-child(1) fuse-nav-vertical-collapsable:nth-child(2) > div > fuse-nav-vertical-item:nth-child(6) > a")
    private WebElement departmentMenu;
    @FindBy(css="toolbar h3")
    private WebElement toolbarTitle;

    public MenuPOM(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);

        PageFactory.initElements(driver, this);
    }

    public void navigateToSetup() {
        waitFor(ExpectedConditions.visibilityOf(setupMenu), "Setup Menu not visible");
        setupMenu.click();
    }

    public void navigateToSchoolSetupMenu() {
        waitFor(ExpectedConditions.visibilityOf(schoolSetupMenu), "School Setup Menu not visible");
        schoolSetupMenu.click();
    }

    public void navigateToDepartmentMenu() {
        waitFor(ExpectedConditions.visibilityOf(departmentMenu), "Department Menu not visible");
        departmentMenu.click();
    }

    public void waitToolbarHeader(String text) {
        waitFor(ExpectedConditions.textToBePresentInElement(toolbarTitle, text), "We did not navigate to correct menu");
    }
}
