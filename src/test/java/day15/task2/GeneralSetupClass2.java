package day15.task2;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class GeneralSetupClass2 {
    @BeforeSuite
    public void setUp(){
        System.out.println("Suite Setup 2");
    }

    @AfterSuite
    public void tearDown(){
        System.out.println("Suite Teardown 2");
    }
}
