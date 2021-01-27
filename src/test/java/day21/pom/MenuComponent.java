package day21.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuComponent {
    WebDriver driver;
    public By setupMenu = By.cssSelector(".group-items > :nth-child(1)");
    public By schoolSetupMenu = By.cssSelector(".group-items > :nth-child(1) fuse-nav-vertical-collapsable:nth-child(2)");
    public By departmentMenu = By.cssSelector(".group-items > :nth-child(1) fuse-nav-vertical-collapsable:nth-child(2) > div > fuse-nav-vertical-item:nth-child(6) > a");
    public By toolbarTitle = By.cssSelector("toolbar h3");

    public MenuComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToSetup() {
        driver.findElement(this.setupMenu).click();
    }

    public void navigateToSchoolSetupMenu() {
        driver.findElement(this.schoolSetupMenu).click();
    }

    public void navigateToDepartmentMenu() {
        driver.findElement(this.departmentMenu).click();
    }
}
