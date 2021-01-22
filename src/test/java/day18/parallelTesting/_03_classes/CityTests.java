package day18.parallelTesting._03_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CityTests {
    @BeforeClass
    public void setNUp() {
        System.setProperty("webdriver.chrome.driver", StudentConstants.CHROME_DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        System.out.println("CitizenshipTests no group setup");
    }
    @Test
    public void testCase1(){
        System.out.println("City test case functional 1");
    }

    @Test
    public void testCase2(){
        System.out.println("City test case functional and smoke 2");
    }

    @Test
    public void testCase3(){
        System.out.println("City test case smoke 3");
    }

    @Test
    public void testCase4(){
        System.out.println("City test case regression 4");
    }
}
