package org.wahlzeit.model;

import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.assertTrue;

public class CartesianCoordinateTest {

    @Test(expected = IllegalArgumentException.class)
    public void testVectorConstructorWithFalseValues(){
        Vector<Double> v = new Vector<>();
        v.add(Double.NaN);
        v.add(10.0);
        v.add(Double.NEGATIVE_INFINITY);
        CartesianCoordinate c = CartesianCoordinate.getInstance(v);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testVectorConstructorWithTooSmallVector(){
        Vector<Double> v = new Vector<>();
        v.add(5.0);
        v.add(10.0);
        CartesianCoordinate c = CartesianCoordinate.getInstance(v);
    }

    @Test
    public void testValueObjectFunctionality(){
        CartesianCoordinate c = CartesianCoordinate.getInstance(10.0,10.0,10.0);
        CartesianCoordinate f = CartesianCoordinate.getInstance(10.0,10.0,10.0);

        assertTrue(c == f);
    }


}
