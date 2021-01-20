package day17.depencyInjection.task;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Task1Tests {
    @BeforeMethod
    public void beforeMethod(Method m) {
        System.out.println("Method name: " + m.getName());
    }

    @AfterMethod
    public void afterMethod(ITestResult r) {
        String result = "unknown";
        switch(r.getStatus()) {
            case ITestResult.SUCCESS:
                result = "success";
                break;
            case ITestResult.FAILURE:
                result = "failure";
                break;
            case ITestResult.SKIP:
                result = "skipped";
                break;
        }
        System.out.println("Result is " + result);
    }

    @Test
    public void test1() {
        System.out.println("success");
    }
    @Test
    public void test2() {
        System.out.println("success");
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
