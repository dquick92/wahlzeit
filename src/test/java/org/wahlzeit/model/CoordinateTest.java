package org.wahlzeit.model;

/**
 * Created on 28.10.16.
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordinateTest {

    @Test
    public void testSphericToCartesian() throws Exception{
        SphericCoordinate sC = SphericCoordinate.getInstance(45, 0, 90);
        CartesianCoordinate cC = CartesianCoordinate.getInstance(63.6,0,63.6);
        CartesianCoordinate tC = CartesianCoordinate.getInstance(sC.asVector());
        assertEquals(cC.getX(), tC.getX(), 0.1);
        assertEquals(cC.getY(), tC.getY(), 0.1);
        assertEquals(cC.getZ(), tC.getZ(), 0.1);

    }

    @Test
    public void testGetDistanceSphericSameRadius() {
            Coordinate sC1 = SphericCoordinate.getInstance(-90, -180, 5);
            Coordinate sC2 = SphericCoordinate.getInstance(90, 180, 5);
            assertEquals(15.7, sC1.getDistance(sC2), 0.01);
    }

    @Test
    public void testGetDistanceSphericDifferentRadius() {
            Coordinate sC1 = SphericCoordinate.getInstance(-90, -180, 1);
            Coordinate sC2 = SphericCoordinate.getInstance(90, 180, 5);
            assertEquals(6, sC1.getDistance(sC2), 0.01);
    }

    @Test
    public void testGetDistanceCartesianImplementation(){
        Coordinate cC1 = CartesianCoordinate.getInstance(0,0,0);
        Coordinate cC2 = CartesianCoordinate.getInstance(10,10,10);
        assertEquals(17.32, cC1.getDistance(cC2), 0.001);

    }
    @Test
    public void testGetDistanceDifferentImplementation() throws IllegalArgumentException {
            Coordinate sC = SphericCoordinate.getInstance(45,45,100);
            Coordinate cC = CartesianCoordinate.getInstance(5,5,-5);
            assertEquals(99, sC.getDistance(cC), 0.1);
    }

}
