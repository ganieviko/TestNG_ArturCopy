package day19;

import org.openqa.selenium.By;

public class Selectors {
    public static By username = By.cssSelector("input[formcontrolname='username']");
    public static By password = By.cssSelector("input[formcontrolname='password']");
    public static By loginButton = By.cssSelector("button[aria-label='LOGIN']");
}
