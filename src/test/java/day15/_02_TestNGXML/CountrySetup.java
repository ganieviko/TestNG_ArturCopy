package day15._02_TestNGXML;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CountrySetup {
    @BeforeClass
    public void setUp(){
        System.out.println("Doing before class setup");
    }

    @AfterMethod
    public void cleanup() {
        System.out.println("After each method");
    }

    @Test
    public void test(){
        System.out.println("Test case 1");
    }
}
