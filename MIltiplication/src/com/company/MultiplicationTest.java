package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTest {
    @Test
    void multi() {
        int num1Test = 5;
        int num2Test = 5;
        Multiplication mlTest = new Multiplication(num1Test, num2Test);
        int result = mlTest.Multi();
        Assertions.assertEquals(25, result);
    }

    @Test
    void Test2(){
        int num1Test = 0;
        int num2Test = 5;
        Multiplication mlTest = new Multiplication(num1Test, num2Test);
        int result = mlTest.Multi();
        Assertions.assertEquals(0, result);
    }

    @Test
    void Tesy2(){
        int num1Test = 1;
        int num2Test = 5;
        Multiplication mlTest = new Multiplication(num1Test, num2Test);
        int result = mlTest.Multi();
        Assertions.assertEquals(5, result);
    }

    @Test
    void Test3() {
        int num1Test = -5;
        int num2Test = -5;
        Multiplication mlTest = new Multiplication(num1Test, num2Test);
        int result = mlTest.Multi();
        Assertions.assertEquals(25, result);
    }
    @Test
    void Test4() {
        int num1Test = -5;
        int num2Test = 5;
        Multiplication mlTest = new Multiplication(num1Test, num2Test);
        int result = mlTest.Multi();
        Assertions.assertEquals(-25, result);
    }

}