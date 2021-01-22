package day18.crossBrowserTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class _01_OpeningDifferentBrowsers {
    @Test
    public void chromeBrowser() {
        System.setProperty("webdriver.chrome.driver", StudentConstants.CHROME_DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get( "https://test.campus.techno.study/" );
    }

    @Test
    public void firefoxBrowser() {
        System.setProperty("webdriver.gecko.driver", StudentConstants.GECKO_DRIVER_PATH);
        WebDriver driver = new FirefoxDriver();

        driver.get("https://test.campus.techno.study/");
    }

    @Test
    public void edgeBrowser() {
        System.setProperty("webdriver.edge.driver", StudentConstants.EDGE_DRIVER_PATH);
        WebDriver driver = new EdgeDriver();

        driver.get("https://test.campus.techno.study/");
    }

}
