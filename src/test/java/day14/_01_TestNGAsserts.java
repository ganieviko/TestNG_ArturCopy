package day14;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class _01_TestNGAsserts {
    @Test
    public void assertEquals() {
        String actual = "Hello";
        String expected = "Hello";
        Assert.assertEquals(actual, expected, "Actual should be equal to Expected");
    }

    @Test
    public void assertEquals2() {
        String actual = "Hello";
        String expected = new String("Hello");
        Assert.assertEquals(actual, expected, "Actual should be equal to Expected");
    }

    @Test
    public void assertEquals3() {
        String[] actual = {"Hello", "2"};
        String[] expected = {"Hello", "2"};
        Assert.assertEquals(actual, expected, "Actual should be equal to Expected");
    }

    @Test
    public void assertEqualsNoOrder() {
        String[] actual = {"Hello", "2"};
        String[] expected = {"2", "Hello"};
        Assert.assertEqualsNoOrder(actual, expected, "Actual should be equal to Expected");
    }

    @Test
    public void assertNotEquals() {
        String[] actual = {"Hello", "2"};
        String[] expected = {"2", "Hello"};
        Assert.assertNotEquals(actual, expected, "Actual should be not equal to Expected");
    }

    @Test
    public void assertNotEquals2() {
        int actual = 1;
        int expected = 2;
        Assert.assertNotEquals(actual, expected, "Actual should be not equal to Expected");
    }

    @Test
    public void assertNotEquals3() {
        double actual = 1.1;
        double expected = 1.09;
        double delta = 0.02;
        Assert.assertNotEquals(actual, expected, delta, "Actual should be not equal to Expected");
    }

    @Test
    public void assertNotNull() {
        Object o = someFunctionThatMightProduceNull();
        Assert.assertNotNull(o, "O should not be null");
        o.toString();
    }

    private Object someFunctionThatMightProduceNull() {
        boolean returnNullOrNot = new Random().nextBoolean();
        return returnNullOrNot ? null : new Object();
    }

    @Test
    public void assertSame() {
        String actual = "Hello";
        String expected = "Hello";
        Assert.assertSame(actual, expected, "Actual should point to same object");
    }

    @Test
    public void assertSame2() {
        String actual = "Hello";
        String expected = new String("Hello");
        Assert.assertSame(actual, expected, "Actual should point to same object");
    }

    @Test
    public void assertNotSame() {
        String actual = new String("Hello");
        String expected = new String("Hello");
        Assert.assertNotSame(actual, expected, "Actual should not point to same object");
    }

    @Test
    public void assertTrue() {
        boolean actual = isDataAvailable();
        Assert.assertTrue(actual);
    }

    @Test
    public void assertFalse() {
        boolean actual = isDataAvailable();
        Assert.assertFalse(actual);
    }

    private boolean isDataAvailable() {
        return new Random().nextBoolean();
    }

    @Test
    public void assertTrueHowNOTtoUSE() {
        String actual = "Hi";
        String expected = "Hello";
        Assert.assertTrue(actual == expected);
    }

    @Test
    public void assertTrueHowNOTtoUSE2() {
        String actual = "Hi";
        String expected = "Hello";
        Assert.assertTrue(actual.equals(expected), "Actual should be equal to expected!");
    }

    @Test
    public void assertEqualsHowToUSE() {
        String actual = "Hi";
        String expected = "Hello";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void assertFail() {
        if (!isDataAvailable()) {
            Assert.fail("The data should be available before continuing the test");
        }
    }

    @Test
    public void assertFailWrapper() {
        try {
            throw new Exception("Custom Exception Message");
        } catch (Exception e) {
            Assert.fail("The test failed because we caught an exception", e);
        }
    }

    @Test
    public void failureTest() throws Exception {
        throw new Exception("Custom Exception Message");
    }
}
