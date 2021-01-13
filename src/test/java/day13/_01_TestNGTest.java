package day13;

import org.testng.annotations.Test;

public class _01_TestNGTest {
    @Test
    public void test1() {
        // automatic exception handling
        // any exception here will fail the test
    }

    @Test
    public void test2() throws Exception {
        throw new Exception();
    }
}
