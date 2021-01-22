package day18.crossBrowserTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class _01_OpeningDifferentBrowsers {
    @Test
    public void chromeBrowser() {
        System.setProperty("webdriver.chrome.driver", StudentConstants.CHROME_DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get( "https://test.campus.techno.study/" );
    }
}
