package day13.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task1BeforeClass {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", MyConstants.DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get( "https://demoqa.com/buttons" );
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    
    @Test
    public void actionClickTestCase() {
        WebElement button = driver.findElement(By.xpath("//button[text()='Click Me']"));

        Actions builder = new Actions(driver);
        Action action = builder.moveToElement(button).click().build();
        action.perform();

        String message = driver.findElement(By.id("dynamicClickMessage")).getText();

        System.out.println(message);

        Assert.assertEquals(message, "You have done a dynamic click");
    }

    @Test
    public void actionDoubleClickTestCase() {
        WebElement button = driver.findElement(By.xpath("//button[text()='Double Click Me']"));

        Actions builder = new Actions(driver);
        Action action = builder.moveToElement(button).doubleClick().build();
        action.perform();

        String message = driver.findElement(By.id("doubleClickMessage")).getText();
        System.out.println(message);

        Assert.assertEquals(message, "You have done a double click");
    }

    @Test
    public void actionRightClickTestCase(){
        WebElement button = driver.findElement(By.xpath("//button[text()='Right Click Me']"));

        Actions builder = new Actions(driver);
        Action action = builder.moveToElement(button).contextClick().build();
        action.perform();

        String message = driver.findElement(By.id("rightClickMessage")).getText();
        System.out.println(message);

        Assert.assertEquals(message, "You have done a right click");
    }
}
