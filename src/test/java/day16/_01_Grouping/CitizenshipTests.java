package day16._01_Grouping;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CitizenshipTests {

    @BeforeClass()
    public void setNUp() {
        System.out.println("CitizenshipTests no group setup");
    }

    @BeforeClass(groups={"functional"})
    public void setFUp() {
        System.out.println("CitizenshipTests functional setup");
    }

    @BeforeClass(alwaysRun = true)
    public void setAUp() {
        System.out.println("CitizenshipTests always run setup");
    }

    @Test(groups={"functional"})
    public void testCase1(){
        System.out.println("Citizenship test case functional 1");
    }

    @Test(groups={"functional", "smoke"})
    public void testCase2(){
        System.out.println("Citizenship test case functional and smoke 2");
    }

    @Test(groups = {"smoke"})
    public void testCase3(){
        System.out.println("Citizenship test case smoke 3");
    }

    @Test(groups = {"regression"})
    public void testCase4(){
        System.out.println("Citizenship test case regression 4");
    }
}
