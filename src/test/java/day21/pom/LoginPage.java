package day21.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public By username = By.cssSelector("input[formcontrolname='username']");
    public By password = By.cssSelector("input[formcontrolname='password']");
    public By loginButton = By.cssSelector("button[aria-label='LOGIN']");
    public By menu = By.cssSelector("svg[data-icon=\"bars\"]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInUserName(String username) {
        driver.findElement(this.username).sendKeys(username);
    }

    public void fillInUserPassword(String password){
        driver.findElement(this.password).sendKeys(password);
    }

    public void login(){
        driver.findElement(loginButton).click();
    }
}
