package day15._04_TestNGXML;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

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
