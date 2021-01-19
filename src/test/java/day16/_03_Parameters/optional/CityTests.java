package day16._03_Parameters.optional;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CityTests {
    @Parameters({"name", "status"})
    @BeforeClass
    public void setup(@Optional("Study") String name, @Optional("off") String status){
        System.out.println("Setting up out test with " + name + " status: " + status);
    }

    @Test
    public void testCase1(){
        System.out.println("City test case 1");
    }
}
