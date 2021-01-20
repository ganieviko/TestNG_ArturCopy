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
