package com.sahil.movieBookingSystem;

import org.junit.jupiter.api.*;

/**
 * This class will be used to demo the Unit Testing
 * JUnit FrameWork functionality
 *
 * @Test
 * @BeforeEach
 * @AfterEach
 * @BeforeAll
 * @AfterAll
 */
public class TestDemo {

    /**
     * Before running any test, we do some preparation
     * It doesn't matter where you write this code,,,you can declare it after myFirstTest method also.but it will given the same results
     */
    @BeforeEach
    public void beforeEachTestMethod(){
        System.out.println("Before each test");

    }

    /**
     * Whenever we use @Test with any method, it becomes executable and test method
     */
    @Test
    public void myFirstTest(){
        System.out.println("Inside the first test");
    }

    @Test
    public void mySecondTest(){
        System.out.println("Inside the second test");
    }

    /**
     * I want to execute something after every test is executed
     */
    @AfterEach
    public void afterEachTestMethod(){
        System.out.println("After each test");
    }

    /**
     *  I want to execute something only once, in the beginning
     */
    @BeforeAll
    public static void veryBeginning(){
        System.out.println("In the very beginning");
    }

    @AfterAll
    public static void lastMethod(){
        System.out.println("In the very end");
    }


}
