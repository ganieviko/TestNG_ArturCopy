package day18.parallelTesting._02_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrowserTest {
    WebDriver driver;
    @Parameters("browser")
    @Test
    public void launchBrowser(String browserName) {
        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", StudentConstants.CHROME_DRIVER_PATH);
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", StudentConstants.GECKO_DRIVER_PATH);
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", StudentConstants.EDGE_DRIVER_PATH);
                driver = new EdgeDriver();
                break;
        }

        driver.get("https://test.campus.techno.study/");
    }

}
