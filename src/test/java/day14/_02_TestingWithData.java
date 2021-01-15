package day14;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_TestingWithData {
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
    public void test1() {
        String country = getCountryFromWebsiteUsingSelenium("New York");
        Assert.assertEquals(country, "USA");
    }

    @Test
    public void test2() {
        String country = getCountryFromWebsiteUsingSelenium("Almaty");
        Assert.assertEquals(country, "Kazakhstan");
    }

    @Test
    public void test3() {
        String country = getCountryFromWebsiteUsingSelenium("Istanbul");
        Assert.assertEquals(country, "Turkey");
    }

    @Test
    public void test4() {
        String country = getCountryFromWebsiteUsingSelenium("Baku");
        Assert.assertEquals(country, "Azerbaijan");
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
