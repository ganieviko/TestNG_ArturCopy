package day19;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SchoolDepartmentTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp()  {
        System.setProperty("webdriver.chrome.driver", StudentConstants.CHROME_DRIVER_PATH);
        driver = new ChromeDriver(); // TODO: parameterize browser
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);

        driver.get("https://test.campus.techno.study/"); // TODO: parameterize the website
    }

    @Parameters({"username", "password"})
    @Test
    public void login(@Optional("daulet2030@gmail.com2") String uname, @Optional("TechnoStudy123@") String upassword) {
        driver.findElement(Selectors.username).sendKeys(uname);
        driver.findElement(Selectors.password).sendKeys(upassword);
        driver.findElement(Selectors.loginButton).click();
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("svg[data-icon=\"bars\"]")));
        } catch (TimeoutException e) {
            Assert.fail("Unable to login using username: " + uname + " and password: " + upassword );
        }
    }


}
