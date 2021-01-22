package day18.parallelTesting._04_groups;

import org.testng.annotations.Test;

public class CityTests {
    @Test(groups={"functional"})
    public void testCase1(){
        System.out.println("City test case functional 1");
    }

    @Test(groups={"functional", "smoke"})
    public void testCase2(){
        System.out.println("City test case functional and smoke 2");
    }

    @Test(groups = {"smoke"})
    public void testCase3(){
        System.out.println("City test case smoke 3");
    }

    @Test(groups = {"regression"})
    public void testCase4(){
        System.out.println("City test case regression 4");
    }
}
