package day21;

import day19.Selectors;
import day19.StudentConstants;
import day21.pom.LoginPage;
import day21.pom.MenuComponent;
import day21.util.BaseTest;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", StudentConstants.CHROME_DRIVER_PATH);
        driver = new ChromeDriver(); // TODO: parameterize browser
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);

        loginPage = new LoginPage(driver);
    }

    @BeforeMethod
    public void navigate() {
        driver.get("https://test.campus.techno.study/");
    }

    @Test
    public void successFullLogin() {
        loginPage.fillInUserName("daulet2030@gmail.com");
        loginPage.fillInUserPassword("TechnoStudy123@");
        loginPage.login();
        waitFor(ExpectedConditions.presenceOfElementLocated(loginPage.menu));
    }

    @Test
    public void unSuccessFullLogin() {
        loginPage.fillInUserName("daulet2030@gmail.com");
        loginPage.fillInUserPassword("password");
        loginPage.login();
        // validate that not logged in
        waitFor(ExpectedConditions.textToBePresentInElementLocated(Selectors.alert, "Invalid username or password"));
    }



}
