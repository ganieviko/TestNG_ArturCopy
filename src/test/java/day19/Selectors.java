package day19;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;

public class Selectors {
    public static By username = By.cssSelector("input[formcontrolname='username']");
    public static By password = By.cssSelector("input[formcontrolname='password']");
    public static By loginButton = By.cssSelector("button[aria-label='LOGIN']");
    public static By menu = By.cssSelector("svg[data-icon=\"bars\"]");
    public static By setupMenu = By.cssSelector(".group-items > :nth-child(1)");
    public static By schoolSetupMenu = By.cssSelector(".group-items > :nth-child(1) fuse-nav-vertical-collapsable:nth-child(2)");
    public static By departmentMenu = By.cssSelector(".group-items > :nth-child(1) fuse-nav-vertical-collapsable:nth-child(2) > div > fuse-nav-vertical-item:nth-child(6) > a");
    public static By locationMenu = By.cssSelector(".group-items > :nth-child(1) fuse-nav-vertical-collapsable:nth-child(2) > div > fuse-nav-vertical-item:nth-child(5) > a");
    public static By plusButton = By.cssSelector("ms-table-toolbar > div ms-add-button");
    public static By plusButtonOverlay = By.cssSelector(".cdk-overlay-pane ms-table-toolbar > div ms-add-button");
    public static By nameInput = By.cssSelector("[placeholder='GENERAL.FIELD.NAME']>input");
    public static By codeInput = By.cssSelector("[placeholder='GENERAL.FIELD.CODE']>input");
    public static By shortNameInput = By.cssSelector("[placeholder='GENERAL.FIELD.SHORTNAME']>input");
    public static By capacityInput = By.cssSelector("ms-text-field[formcontrolname=\"capacity\"]>input");
    public static By sectionTab = By.xpath("//div[text()='Section']");
    public static By addSectionButton = By.cssSelector("school-department-section ms-button");
    public static By sectionRows = By.cssSelector("school-department-section tr");
    public static By saveButton = By.cssSelector("ms-save-button");
    public static By browserTableRows = By.cssSelector("ms-browse-table tr");
    public static By trashButton = By.cssSelector("ms-delete-button");
    public static By confirmYes = By.cssSelector("button[type='submit']");
    public static By alert = By.cssSelector("div[role='alertdialog']");
}
