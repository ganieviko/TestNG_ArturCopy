package day15.task2;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestSetupClass {
    @BeforeTest
    public void setUpTest() {
        System.out.println("    Test Setup");
    }

    @AfterTest
    public void tearDownTest() {
        System.out.println("    Test Teardown");
    }

}
