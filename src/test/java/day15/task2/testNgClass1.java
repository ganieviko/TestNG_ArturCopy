package day15.task2;

import org.testng.annotations.*;

public class testNgClass1 {
    @BeforeClass
    public void setUp() {
        System.out.println("        class setup 1");
    }
    @AfterClass
    public void tearDown() {
        System.out.println("        class teardown 1");
    }

    @BeforeMethod
    public void setUpMethod() {
        System.out.println("            method setup 1");
    }
    @AfterMethod
    public void tearDownMethod() {
        System.out.println("            method teardown 1");
    }

    @Test
    public void test1() {
                    System.out.println("                test 1");
    }

    @Test
    public void test2() {
        System.out.println("                test 2");
    }
}
