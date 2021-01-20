package day17.depencyInjection;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class SimpleTests {

    @BeforeClass
    public void printAllMethods(ITestContext context) {
        ITestNGMethod[] allTestMethods = context.getAllTestMethods();
        for (ITestNGMethod method: allTestMethods) {
            System.out.println(method.getMethodName());
        }
    }

    @Test
    public void successfulTestCase(ITestContext context) {
        String testNgXmlPath = context.getSuite().getXmlSuite().getFileName();
        System.out.println(testNgXmlPath);

        System.out.println("Successful Test Case");
    }

    @Test
    public void failedTestCase() {
        Assert.fail("Failed Test Case");
    }

    @Test(dependsOnMethods = {"failedTestCase"})
    public void skippedTestCase() {
        System.out.println("Skipped Test Case");
    }

    @Test
    public void sometimesSkippedTestCase() {
        boolean websiteLoginIsAvailable = new Random().nextBoolean();
        if(!websiteLoginIsAvailable) {
            throw new SkipException("Skipped Test Case");
        } else {
            System.out.println("Successful Test Case");
        }
    }

    @Test
    public void errorTestCase() {
        throw new RuntimeException("Error Test case");
    }
}
