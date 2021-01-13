package day13;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _02_TestNGBeforeAfter {
    @BeforeMethod
    public void beforeEachTest(){
        System.out.println("Do something before each test");
    }

    @AfterMethod
    public void afterEachTest() {
        System.out.println("Do something after each test");
    }

    @Test
    public void test1() {
        System.out.println("This is successful test 1");
        // each test case should have at least one Assertion
        Assert.assertEquals("test", "test");

    }

    @Test
    public void test2() {
        Assert.assertEquals("not test", "test");
    }

    @Test
    public void test3() throws Exception {
        // automatic exception handling
        // any exception here will fail the test

        // something wrong in the code
        throw new Exception();
    }

    @Test
    public void test4() throws Exception {
        // something wrong in the business logic (software under test)
        boolean someCondition = true;
        if (someCondition) {
            Assert.fail("Test failed because of some condition");
        }
    }


}
