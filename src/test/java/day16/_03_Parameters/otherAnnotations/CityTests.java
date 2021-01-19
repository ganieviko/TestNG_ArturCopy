package day16._03_Parameters.otherAnnotations;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CityTests {
    @Parameters({"name"})
    @BeforeClass
    public void setup(String name){
        System.out.println("Setting up out test with " + name);
    }
    @Parameters({"status"})
    @Test
    public void testCase2(String status){
        System.out.println("City test case 2 for status: " + status);
    }
    @Parameters({"name"})
    @Test
    public void testCase3(String name){
        System.out.println("City test case 3 " + name);
    }
}
