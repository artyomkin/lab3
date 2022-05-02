package com.example.demo;

import org.junit.*;
import static org.junit.Assert.*;
public class TestHitChecker extends Assert{
    @Before
    public void setUp() {
        System.out.println("HI");
    }
 
    @Test
    public void testHitChecker() {
         assertEquals(true,true);
    }
    
}