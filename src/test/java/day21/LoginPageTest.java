package day21;

import day19.StudentConstants;
import day21.pom.LoginPOM;
import day21.util.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @Test(dataProvider = "loginTestCases")
    public void dataDrivenLoginTestCase(String username, String password, String successExpected) {
        loginPage.fillInUserName(username);
        loginPage.fillInUserPassword(password);
        loginPage.login();

        // verify results
        switch (successExpected) {
            case "success":
                loginPage.waitForMenu();
                break;
            case "failureMessage":
                loginPage.waitForErrorMessage("Invalid username or password");
                break;
        }

    }

    @DataProvider(name = "loginTestCases")
    public Object[][] loginData() {
        Object[][] data = new Object[][]{
                {"daulet2030@gmail.com", "TechnoStudy123@", "success"},
                {"daulet2030@gmail.com", "password", "failureMessage"},
                {"daulet20302@gmail.com", "TechnoStudy123@", "failureMessage"},
                {"", "TechnoStudy123@", "failureUsername"},
                {"daulet2030@gmail.com", "", "failurePassword"},
                {"", "", "failureUsernameAndPassword"},
                {" ", " ", "failureMessage"},
                {"sdfa@sdf", "1241!2asdf", "failureMessage"},
        };
        return data;
    }

}
