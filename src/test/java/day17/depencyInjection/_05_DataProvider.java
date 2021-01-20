package day17.depencyInjection;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class _05_DataProvider {
    @BeforeMethod
    public void accessParameters(Object[] parameters, Method method) {
        System.out.println(method.getName() + " will access " + Arrays.toString(parameters) + " as parameters");
    }

    @Test(dataProvider = "customProvider")
    public void test1(String actualCity, int number, Object o) {
        System.out.println(actualCity);
        System.out.println(number);
        System.out.println(o);
    }

    @Test(dataProvider = "customProvider")
    public void test2(String actualCity, int number, Object o) {
        System.out.println(actualCity);
        System.out.println(number);
        System.out.println(o);
    }

    @DataProvider(name = "customProvider")
    public Object[][] dataProvider2(Method method) {
        System.out.println(method.getName() + " is accessing data provider");
        Object[][] testData = null;
        if (method.getName().equals("test1")) {
            testData = new Object[][]{
                    {"New York", 1, new Object()},
                    {"Almaty", 2, new Object()},
                    {"Istanbul", 3, null},
                    {"Baku", 4, new Object()}
                    // ... 100 rows ...
            };
        } else {
            testData = new Object[][]{
                    {"New Jersey", 1, new Object()},
                    {"Astana", 2, new Object()},
                    {"Ankara", 3, null},
                    {"Gence", 4, new Object()}
                    // ... 100 rows ...
            };
        }
        return testData;
    }

}
