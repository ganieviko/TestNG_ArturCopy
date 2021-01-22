package day18.parallelTesting._03_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CityTests {
    private WebDriverWait wait;
    private WebDriver driver;
    private long start;

    @BeforeClass
    public void setUp() {
        start = System.currentTimeMillis() / 1000;
        System.setProperty("webdriver.chrome.driver", StudentConstants.CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get( "https://test.campus.techno.study/" );
        wait = new WebDriverWait(driver, 5);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        System.out.println((System.currentTimeMillis()/1000) - start);
    }

    @Test
    public void loginTestCase() {
        driver.findElement(By.cssSelector("input[data-placeholder=\"Username\"]")).sendKeys("daulet2030@gmail.com");
        driver.findElement(By.cssSelector("input[data-placeholder=\"Password\"]")).sendKeys("TechnoStudy123@");
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("svg[data-icon=\"bars\"]")));
    }

    @Test(dependsOnMethods = {"loginTestCase"})
    public void menuNavigationTest() {
        String parentMenu = ".group-items > :nth-child(1)";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(parentMenu)));
        driver.findElement(By.cssSelector(parentMenu)).click();

        String secondLevelMenu = " > .children > :nth-child(1)";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(parentMenu + secondLevelMenu)));
        driver.findElement(By.cssSelector(parentMenu + secondLevelMenu)).click();

        String thirdLevelMenu = " > .children > :nth-child(2)";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(parentMenu + secondLevelMenu + thirdLevelMenu)));
        driver.findElement(By.cssSelector(parentMenu + secondLevelMenu + thirdLevelMenu)).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("toolbar h3"), "Cities"));
        Assert.assertEquals(driver.findElement(By.cssSelector("toolbar h3")).getText(), "Cities");
    }
}
