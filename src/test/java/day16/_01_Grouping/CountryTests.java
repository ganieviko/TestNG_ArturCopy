package day16._01_Grouping;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class CountryTests {
    @Test(groups={"functional"})
    public void testCase1(){
        System.out.println("Country test case functional 1");
    }
    @Test(groups={"functional"})
    public void testCase2(){
        System.out.println("Country test case functional 2");
    }
    @Test(groups = {"smoke"})
    public void testCase3(){
        System.out.println("Country test case smoke 3");
    }
}
