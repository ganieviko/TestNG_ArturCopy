package day17.depencyInjection;

import org.testng.*;
import org.testng.annotations.*;
import org.testng.xml.XmlTest;

import java.lang.reflect.Method;
import java.util.Random;

public class SimpleTests {

    @BeforeClass
    public void printAllMethods(ITestContext context) {
        ITestNGMethod[] allTestMethods = context.getAllTestMethods();
        for (ITestNGMethod method: allTestMethods) {
            System.out.println(method.getMethodName());
        }
    }

    @BeforeTest
    public void beforeMethod(XmlTest test) {
        String testName = test.getName();
        System.out.println("-------------- " +  testName + " --------------");
    }

    @BeforeMethod
    public void beforeMethod(Method method){
        System.out.println("Before method: " + method.getName());
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        System.out.println("Test status is: " + result.getStatus());
        // TODO: if test is failed take a screenshot
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
