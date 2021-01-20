package day17.depencyInjection.task2;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import java.lang.reflect.Method;

public class CityTests {
    @BeforeMethod
    public void beforeMethod(Method m) {
        System.out.println("--------------------" + m.getName() + "--------------------");
    }
    @BeforeTest
    public void beforeTest(XmlTest t) {
        System.out.println("----------------------------------------" + t.getName() + "----------------------------------------");
    }
    @Test
    public void test3() {
        System.out.println("success");
    }
    @Test
    public void test4() {
        Assert.fail("fail");
    }
    @Test
    public void test5() {
        throw new SkipException("skipped");
    }

}
