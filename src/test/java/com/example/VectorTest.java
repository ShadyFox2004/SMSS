package com.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class VectorTest {
    @Test
    public void testAdd() {
        String actual = new Vector(3,3).add(new Vector(3, 3)).toString();
        String expected = new Vector(6, 6).toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testDotProduct() {
        //Vector firstTestVector = new Vector(0.0, 1.0);
        //Vector secondTestVector = new Vector(1.0, 0.0);
    }

    @Test
    public void testGetAngleBetween() {

    }

    @Test
    public void testGetMagnitude() {

    }

    @Test
    public void testRotate() {

    }

    @Test
    public void testScalarProduct() {

    }

    @Test
    public void testVectorProjection() {

    }
}
