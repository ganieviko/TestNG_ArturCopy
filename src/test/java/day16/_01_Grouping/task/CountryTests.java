package day16._01_Grouping.task;

import org.testng.annotations.Test;

public class CountryTests {
    @Test(groups={"functional", "smoke"})
    public void testCase1(){
        System.out.println("Country test case functional 1");
    }
    @Test(groups={"regression"})
    public void testCase2(){
        System.out.println("Country test case regression 2");
    }
    @Test(groups = {"smoke"})
    public void testCase3(){
        System.out.println("Country test case smoke 3");
    }
}
