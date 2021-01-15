package day14;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _04_TestingWithDataProvider {
    /*
     * City     | Country
     * -------------------------
     * New York | USA
     * Almaty   | Kazakhstan
     * Istanbul | Turkey
     * Baku | Azerbaijan
     *  ... 100 rows ... ???
     */

    @Test(dataProvider="countryCityProvider")
    public void test(String actualCity, String expectedCountry) {
        String actualCountry = getCountryFromWebsiteUsingSelenium(actualCity);
        Assert.assertEquals(actualCountry, expectedCountry);
    }

    @DataProvider(name = "countryCityProvider")
    public Object[][] dataProvider1() {
        String[][] testData = {
                {"New York", "USA"},
                {"Almaty", "Kazakhstan"},
                {"Istanbul", "Turkey1"},
                {"Baku1", "Azerbaijan1"}
                // ... 100 rows ...
        };
        return testData;
    }


    // black box
    public String getCountryFromWebsiteUsingSelenium(String city) { // this is software that we are testing
        String country = null;
        switch (city) {
            case "New York":
                country = "USA";
                break;
            case "Almaty":
                country = "Kazakhstan";
                break;
            case "Istanbul":
                country = "Turkey";
                break;
            case "Baku":
                country = "Azerbaijan";
                break;
        }
        return country;
    }
}
