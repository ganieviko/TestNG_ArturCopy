package day15.task2;

import org.testng.annotations.*;

public class testNgClass2 {
    @Test
    public void test1() {
        System.out.println("               test 1");
    }

    @Test
    public void test2() {
        System.out.println("                test 2");
    }

    @BeforeClass
    public void setUp() {
        System.out.println("        class setup 2");
    }
    @AfterClass
    public void tearDown() {
        System.out.println("        class teardown 2");
    }

    @BeforeMethod
    public void setUpMethod() {
        System.out.println("            method setup 2");
    }
    @AfterMethod
    public void tearDownMethod() {
        System.out.println("            method teardown 2");
    }
}
