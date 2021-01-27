package day21.pom;

import day19.Selectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPOM {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css="input[formcontrolname='username']")
    private WebElement username;

    @FindBy(css="input[formcontrolname='password']")
    private WebElement password;

    @FindBy(css="button[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(css="svg[data-icon=\"bars\"]")
    private WebElement menu;

    @FindBy(css="div[role='alertdialog']")
    private WebElement alert;

    public LoginPOM(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public void fillInUserName(String username) {
        this.username.sendKeys(username);
    }

    public void fillInUserPassword(String password){
        this.password.sendKeys(password);
    }

    public void login(){
        loginButton.click();
    }

    public void waitForMenu() {
        wait.until(ExpectedConditions.visibilityOf(menu));
    }

    public void waitForErrorMessage(String message) {
        wait.until(ExpectedConditions.textToBePresentInElement(alert, message));
    }
}
