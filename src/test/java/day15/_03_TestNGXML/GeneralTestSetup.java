package day15._03_TestNGXML;

import org.testng.annotations.*;

public class GeneralTestSetup {
    @BeforeTest
    public void testSetUp(){
        System.out.println("Before Test");
    }

    @BeforeSuite
    public void setUp() {
        System.out.println("Before Suite");
    }
}
