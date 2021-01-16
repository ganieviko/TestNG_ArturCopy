package day15.task2;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class GeneralSetupClass {
    @BeforeSuite
    public void setUp(){
        System.out.println("Suite Setup");
    }

    @AfterSuite
    public void tearDown(){
        System.out.println("Suite Teardown");
    }

    @BeforeTest
    public void setUpTest() {
        System.out.println("    Test Setup");
    }

    @AfterTest
    public void tearDownTest() {
        System.out.println("    Test Teardown");
    }

}
