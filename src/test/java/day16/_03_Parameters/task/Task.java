package day16._03_Parameters.task;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Task {
    @Parameters({"username", "password"})
    @Test
    public void testCase(String username, String password){
        System.out.println("Using username: " + username);
        System.out.println("Using password: " + password);
    }
}
