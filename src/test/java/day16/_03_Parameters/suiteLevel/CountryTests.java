package day16._03_Parameters.suiteLevel;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CountryTests {
    @Parameters({"name"})
    @Test
    public void testCase1(String p1){
        System.out.println("Country test case 1 " + p1);
    }
    @Parameters({"status"})
    @Test
    public void testCase2(String s){
        System.out.println("Country test case 2 " + s);
    }
    @Test
    public void testCase3(){
        System.out.println("Country test case 3");
    }

    @AfterTest
    public void testTearDown(){
        System.out.println("After Test");
    }

    @AfterSuite
    public void tearDown() {
        System.out.println("After Suite");
    }
}
