package org.wahlzeit.model;

import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AbstractCoordinateTest {

    CartesianCoordinate cC;
    SphericCoordinate sC;

    @Test(expected = NullPointerException.class)
    public void testIsEqualWithNull(){
        cC = CartesianCoordinate.getInstance(0,0,0);
        assertTrue(cC.isEqual(null));
    }

    @Test
    public void testEqualSameCoordinate(){
        sC = SphericCoordinate.getInstance(23,47,5);
        assertTrue(sC.isEqual(sC));

        cC = CartesianCoordinate.getInstance(sC.asVector());
        assertTrue(sC.isEqual(cC));
    }

    @Test
    public void testEqualDifferentCoordinates(){
        CartesianCoordinate cC1 = CartesianCoordinate.getInstance(10,10,10);
        CartesianCoordinate cC2 = CartesianCoordinate.getInstance(0,0,0);
        assertFalse(cC1.isEqual(cC2));
    }

    @Test
    public void testGetDistanceSphericCoordinatesWithSameRadius(){
        sC = SphericCoordinate.getInstance(-90, 180, 5);
        SphericCoordinate sC1 = SphericCoordinate.getInstance(90,180,5);
        assertEquals(5*Math.PI,sC.getDistance(sC1), 0.1);
    }

    @Test
    public void testGetDistanceSphericCoordinatesWithDifferentRadius(){
        sC = SphericCoordinate.getInstance(-90,180,5);
        SphericCoordinate sC1 = SphericCoordinate.getInstance(90,180,4);
        assertEquals(9.0, sC.getDistance(sC1), 0.1);
    }

    @Test
    public void testGetDistanceCartesianAndSpheric(){
        sC = SphericCoordinate.getInstance(-90,180,5);
        cC = CartesianCoordinate.getInstance(0,0,0);
        assertEquals(5, sC.getDistance(cC), 0.1);
    }

    @Test(expected=NullPointerException.class)
    public void testGetDistanceWithNull(){
        cC = CartesianCoordinate.getInstance(0,0,0);
        cC.getDistance(null);
    }

    @Test
    public void testEqualsCartesianAndSpheric(){
        sC = SphericCoordinate.getInstance(23,47,5);
        cC = CartesianCoordinate.getInstance(sC.asVector());

        assertTrue(sC.equals(cC));
    }

    @Test
    public void testVectorHashCode(){
        Vector<Double> a = new Vector<>();
        a.add(-90.0);
        a.add(180.0);
        a.add(5.0);
        Vector<Double> b = new Vector<>();
        b.add(-90.0);
        b.add(180.0);
        b.add(5.0);

        assertEquals(a.hashCode(), b.hashCode(), 0);
    }





}
