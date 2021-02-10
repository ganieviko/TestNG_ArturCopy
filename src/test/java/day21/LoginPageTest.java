package day21;

import day19.StudentConstants;
import day21.pom.LoginPOM;
import day21.util.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ExcelReader;

import java.io.IOException;
import java.util.List;

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
    public void dataDrivenLoginTestCase(String username, String password, String expectedResult) {
        loginPage.fillInUserName(username);
        loginPage.fillInUserPassword(password);
        loginPage.login();

        // verify results
        switch (expectedResult) {
            case "success":
                loginPage.waitForMenu();
                break;
            case "failureMessage":
                loginPage.waitForErrorMessage("Invalid username or password");
                break;
            case "failureUsername":
                loginPage.waitForEmailError();
                break;
            case "failurePassword":
                loginPage.waitForPasswordError();
                break;
            case "failureUsernameAndPassword":
                loginPage.waitForEmailError();
                loginPage.waitForPasswordError();
                break;
            default:
                Assert.fail("Did not recognize expected result: " + expectedResult);
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

    @Test(dataProvider = "loginTestCasesFromExcel")
    public void dataDrivenLoginTestCaseWithExcel(String username, String password, String expectedResult) {
        loginPage.fillInUserName(username);
        loginPage.fillInUserPassword(password);
        loginPage.login();

        // verify results
        switch (expectedResult) {
            case "success":
                loginPage.waitForMenu();
                break;
            case "failureMessage":
                loginPage.waitForErrorMessage("Invalid username or password");
                break;
            case "failureUsername":
                loginPage.waitForEmailError();
                break;
            case "failurePassword":
                loginPage.waitForPasswordError();
                break;
            case "failureUsernameAndPassword":
                loginPage.waitForEmailError();
                loginPage.waitForPasswordError();
                break;
            default:
                Assert.fail("Did not recognize expected result: " + expectedResult);
        }
    }

    @DataProvider(name = "loginTestCasesFromExcel")
    public Object[][] loginDataFromExcel() throws IOException {
        ExcelReader reader = new ExcelReader("src/test/resources/login_test_cases.xlsx");
        List<List<String>> rows = reader.getLists();
        Object[][] data = new Object[rows.size()][];
        for (int i = 0; i < rows.size(); i++) {
            List<String> row = rows.get(i);
            data[i] = new Object[3];
            for (int j = 0; j < row.size(); j++) {
                data[i][j] = row.get(j);
            }
        }
        return data;
    }
}
