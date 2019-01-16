package group7.tractrac;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTestTest {

    @Test
    public void convertFtoC() throws  Exception {
        float input = 212;
        float output;
        float expected = 100;
        double delta = 0.1;

        UnitTest unitTest = new UnitTest();

        output = unitTest.convertFtoC(input);
        assertEquals(expected,output,delta);
    }

    @Test
    public void convertCtoF() throws Exception {
        float input = 100;
        float output;
        float expected = 212;
        double delta = 0.1;

        UnitTest unitTest = new UnitTest();

        output = unitTest.convertCtoF(input);
        assertEquals(expected,output,delta);
    }
}