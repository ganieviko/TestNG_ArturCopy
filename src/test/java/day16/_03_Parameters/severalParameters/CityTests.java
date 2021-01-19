package day16._03_Parameters.severalParameters;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CityTests {
    @Parameters({"name", "status"})
    @BeforeClass
    public void setup(String name, String status){
        System.out.println("Setting up out test with " + name + " status: " + status);
    }

    @Test
    public void testCase1(){
        System.out.println("City test case 1");
    }
}
