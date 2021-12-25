package com.company;

import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class ComputeWageTest {

    ComputeWage obj = new ComputeWage();
    @BeforeEach
    public void InitEach(){

        ByteArrayInputStream in = new ByteArrayInputStream
                ("John\n35".getBytes());
        System.setIn(in);

    }

    @org.junit.jupiter.api.Test
    void acceptData() {

     obj.AcceptData();

     assertEquals("John", obj.getName());
     assertEquals(35,obj.getHours());


    }

    @org.junit.jupiter.api.Test
    void COmputeWage() {
        obj.AcceptData();
        obj.COmputeWage();
        assertEquals(525,obj.getGtotal());

    }

    @org.junit.jupiter.api.Test
    void display() {

            obj.AcceptData();
            obj.COmputeWage();

        PrintStream standardOut = System.out;
        ByteArrayOutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        obj.Display();
        assertEquals("The total wage of John is 525.0", captor.toString().trim());

        System.setOut(standardOut);

    }
    void TestException(){
        ByteArrayInputStream in = new ByteArrayInputStream("John\nxx\n35".getBytes());
        System.setIn(in);

        PrintStream standardOut = System.out;
        ByteArrayOutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        obj.AcceptData();
        assertTrue(new String(captor.toByteArray()).contains("You did not enter a valid Number"));

    }
}