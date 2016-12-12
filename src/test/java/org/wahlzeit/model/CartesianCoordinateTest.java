package org.wahlzeit.model;

import org.junit.Test;

import java.util.Vector;

public class CartesianCoordinateTest {

    @Test(expected = IllegalArgumentException.class)
    public void testVectorConstructorWithFalseValues(){
        Vector<Double> v = new Vector<>();
        v.add(Double.NaN);
        v.add(10.0);
        v.add(Double.NEGATIVE_INFINITY);
        CartesianCoordinate c = new CartesianCoordinate(v);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testVectorConstructorWithTooSmallVector(){
        Vector<Double> v = new Vector<>();
        v.add(5.0);
        v.add(10.0);
        CartesianCoordinate c = new CartesianCoordinate(v);
    }



}
