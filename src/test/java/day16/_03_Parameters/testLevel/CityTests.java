package day16._03_Parameters.testLevel;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CityTests {
    @Parameters({"name"})
    @Test
    public void testCase1(String name){
        System.out.println("City test case 1 for name: " + name);
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
