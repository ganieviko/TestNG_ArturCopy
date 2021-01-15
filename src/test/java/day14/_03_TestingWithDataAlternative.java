package day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _03_TestingWithDataAlternative {
    /*
     * City     | Country
     * -------------------------
     * New York | USA
     * Almaty   | Kazakhstan
     * Istanbul | Turkey
     * Baku | Azerbaijan
     *  ... 100 rows ... ???
     */

    @Test
    public void test() {
        String[][] testData = {
            {"New York", "USA"},
            {"Almaty", "Kazakhstan"},
            {"Istanbul", "Turkey1"},
            {"Baku1", "Azerbaijan"}
            // ... 100 rows ...
        };

        SoftAssert sa = new SoftAssert();
        for (String[] countryCityPair : testData) {
            String country = getCountryFromWebsiteUsingSelenium(countryCityPair[0]);
            sa.assertEquals(country, countryCityPair[1]);
        }
        sa.assertAll();
//        String country = getCountryFromWebsiteUsingSelenium("New York");
//        Assert.assertEquals(country, "USA");

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
