package org.wahlzeit.model;

import org.junit.Test;
import org.mockito.exceptions.misusing.NullInsteadOfMockException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AbstractCoordinateTest {

    CartesianCoordinate cC;
    SphericCoordinate sC;

    @Test(expected = NullPointerException.class)
    public void testIsEqualWithNull(){
        cC = new CartesianCoordinate(0,0,0);
        assertTrue(cC.isEqual(null));
    }

    @Test
    public void testEqualSameCoordinate(){
        sC = new SphericCoordinate(23,47,5);
        assertTrue(sC.isEqual(sC));

        cC = new CartesianCoordinate(sC.asVector());
        assertTrue(sC.isEqual(cC));
    }

    @Test
    public void testEqualDifferentCoordinates(){
        CartesianCoordinate cC1 = new CartesianCoordinate(10,10,10);
        CartesianCoordinate cC2 = new CartesianCoordinate(0,0,0);
        assertFalse(cC1.isEqual(cC2));
    }

    @Test
    public void testGetDistanceSphericCoordinatesWithSameRadius(){
        sC = new SphericCoordinate(-90, 180, 5);
        SphericCoordinate sC1 = new SphericCoordinate(90,180,5);
        assertEquals(5*Math.PI,sC.getDistance(sC1), 0.1);
    }

    @Test
    public void testGetDistanceSphericCoordinatesWithDifferentRadius(){
        sC = new SphericCoordinate(-90,180,5);
        SphericCoordinate sC1 = new SphericCoordinate(90,180,4);
        assertEquals(9, sC.getDistance(sC1), 0.1);
    }

    @Test
    public void testGetDistanceCartesianAndSpheric(){
        sC = new SphericCoordinate(-90,180,5);
        cC = new CartesianCoordinate(0,0,0);
        assertEquals(5, sC.getDistance(cC), 0.1);
    }

    @Test(expected=NullPointerException.class)
    public void testGetDistanceWithNull(){
        cC = new CartesianCoordinate(0,0,0);
        cC.getDistance(null);
    }






}
