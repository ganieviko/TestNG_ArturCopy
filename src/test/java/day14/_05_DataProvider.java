package day14;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _05_DataProvider {
    @Test(dataProvider = "countryCityProvider")
    public void test(String actualCity) {
        System.out.println(actualCity);
    }

    @DataProvider(name = "countryCityProvider")
    public Object[][] dataProvider1() {
        String[][] testData = {
                {"New York"},
                {"Almaty"},
                {"Istanbul"},
                {"Baku"}
                // ... 100 rows ...
        };
        return testData;
    }

    @Test(dataProvider = "customProvider")
    public void test2(String actualCity, int number, Object o) {
        System.out.println(actualCity);
        System.out.println(number);
        System.out.println(o);
    }

    @DataProvider(name = "customProvider")
    public Object[][] dataProvider2() {
        Object[][] testData = {
                {"New York", 1, new Object()},
                {"Almaty", 2, new Object()},
                {"Istanbul", 3, null},
                {"Baku", 4, new Object()}
                // ... 100 rows ...
        };
        return testData;
    }

}
