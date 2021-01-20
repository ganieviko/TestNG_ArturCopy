package day17;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Random;

public class SimpleTests {
    @Test
    public void successfulTestCase() {
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
