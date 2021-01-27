package day21;

import day19.StudentConstants;
import day21.pom.LoginPOM;
import day21.util.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    private WebDriver driver;
    private LoginPOM loginPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", StudentConstants.CHROME_DRIVER_PATH);
        driver = new ChromeDriver(); // TODO: parameterize browser
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);

        loginPage = new LoginPOM(driver);
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
        loginPage.waitForMenu();
    }

    @Test
    public void unSuccessFullLogin() {
        loginPage.fillInUserName("daulet2030@gmail.com");
        loginPage.fillInUserPassword("password");
        loginPage.login();
        // validate that not logged in
        loginPage.waitForErrorMessage("Invalid username or password");
    }


}
