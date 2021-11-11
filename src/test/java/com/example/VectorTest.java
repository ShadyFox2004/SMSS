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
        Vector firstVector = new Vector(0.0, 1.0);
        Vector secondVector = new Vector(1.0, 0.0);
        
        double expected = 0.0;
        double actual = firstVector.dotProduct(secondVector); 
        assertEquals(expected, actual, 0.000001);
    }

    @Test
    public void testGetAngleBetween() {
        Vector firstVector = new Vector(0.0, 1.0);
        Vector secondVector = new Vector(1.0, 0.0);
        
        double expected = Math.PI / 2.0;
        double actual = Vector.getAngleBetween(firstVector, secondVector); 
        assertEquals(expected, actual, 0.000001);
    }

    @Test
    public void testGetMagnitude() {
        Vector firstVector = new Vector(2.0, 2.0);
        
        double expected = Math.sqrt(8.0);
        double actual = firstVector.getMagnitude(); 
        assertEquals(expected, actual, 0.000001);
    }

    @Test
    public void testRotate() {
        Vector firstVector = new Vector(0.0, 1.0);

        String actual = firstVector.rotate(Math.PI / 2.0).toString();
        String expected = new Vector(-1.0, 0.0).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testScalarProduct() {

    }

    @Test
    public void testVectorProjection() {

    }
}
