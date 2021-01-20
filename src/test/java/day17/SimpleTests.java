package day17;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

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
    public void skippedTestCase2() {
        throw new SkipException("Skipped Test Case");
    }

    @Test
    public void errorTestCase() {
        throw new RuntimeException("Error Test case");
    }
}
