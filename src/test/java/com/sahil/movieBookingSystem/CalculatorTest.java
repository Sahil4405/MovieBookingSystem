package com.sahil.movieBookingSystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Name of the test class : <ClassName>Test
 */
public class CalculatorTest {
    /**
     * Test Add
     *
     * test<MethodName>
     */
    @Test
    public void testAdd(){
        //Excepted result: 2,3 -> 5
        int exceptedResult = 5;

        //Actual Result
        int actualResult = new Calculator().add(2,3);

        /**
         * If actual is matching with excepted
         *
         * yes -> Pass
         * no -> fail
         */
        Assertions.assertEquals(actualResult,exceptedResult);
    }


    /**
     * Test Sub
     */
    @Test
    public void testSub(){
        // excepted result: 5,3 -> 2
        int exceptedResult = 2;

        int actualResult = new Calculator().sub(5,3);

        Assertions.assertEquals(actualResult,exceptedResult);
    }

    /**
     * Test mult
     */

    /**
     * Test Div
     */
}
