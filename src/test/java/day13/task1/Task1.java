package day13.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1 {
    @Test
    public void actionClickTestCase() {
        System.setProperty("webdriver.chrome.driver", MyConstants.DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get( "https://demoqa.com/buttons" );

        WebElement button = driver.findElement(By.xpath("//button[text()='Click Me']"));

        Actions builder = new Actions(driver);
        Action action = builder.moveToElement(button).click().build();
        action.perform();

        String message = driver.findElement(By.id("dynamicClickMessage")).getText();
        driver.quit();

        System.out.println(message);

        Assert.assertEquals(message, "You have done a dynamic click");
    }

    @Test
    public void actionDoubleClickTestCase() {
        System.setProperty("webdriver.chrome.driver", MyConstants.DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get( "https://demoqa.com/buttons" );

        WebElement button = driver.findElement(By.xpath("//button[text()='Double Click Me']"));

        Actions builder = new Actions(driver);
        Action action = builder.moveToElement(button).doubleClick().build();
        action.perform();

        String message = driver.findElement(By.id("doubleClickMessage")).getText();
        System.out.println(message);
        driver.quit();

        Assert.assertEquals(message, "You have done a double click");
    }

    @Test
    public void actionRightClickTestCase(){
        System.setProperty("webdriver.chrome.driver", MyConstants.DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get( "https://demoqa.com/buttons" );

        WebElement button = driver.findElement(By.xpath("//button[text()='Right Click Me']"));

        Actions builder = new Actions(driver);
        Action action = builder.moveToElement(button).contextClick().build();
        action.perform();

        String message = driver.findElement(By.id("rightClickMessage")).getText();
        System.out.println(message);
        driver.quit();

        Assert.assertEquals(message, "You have done a right click");
    }
}
