package org.wahlzeit.model;

/**
 * Created on 28.10.16.
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CoordinateTest {

    @Test
    public void testSphericToCartesian() throws Exception{
        SphericCoordinate sC = new SphericCoordinate(45, 0, 90);
        CartesianCoordinate cC = new CartesianCoordinate(63.6,0,63.6);
        CartesianCoordinate tC = sC.asCartesian();
        assertEquals(cC.getX(), tC.getX(), 0.1);
        assertEquals(cC.getY(), tC.getY(), 0.1);
        assertEquals(cC.getZ(), tC.getZ(), 0.1);

    }

    @Test
    public void testGetDistanceSphericSameRadius() {
            Coordinate sC1 = new SphericCoordinate(-90, -180, 5);
            Coordinate sC2 = new SphericCoordinate(90, 180, 5);
            assertEquals(15.7, sC1.getDistance(sC2), 0.01);
    }

    @Test
    public void testGetDistanceSphericDifferentRadius() {
            Coordinate sC1 = new SphericCoordinate(-90, -180, 1);
            Coordinate sC2 = new SphericCoordinate(90, 180, 5);
            assertEquals(6, sC1.getDistance(sC2), 0.01);
    }

    @Test
    public void testGetDistanceCartesianImplementation(){
        Coordinate cC1 = new CartesianCoordinate(0,0,0);
        Coordinate cC2 = new CartesianCoordinate(10,10,10);
        assertEquals(17.32, cC1.getDistance(cC2), 0.001);

    }
    @Test
    public void testGetDistanceDifferentImplementation() throws IllegalArgumentException {
            Coordinate sC = new SphericCoordinate(45,45,100);
            Coordinate cC = new CartesianCoordinate(5,5,-5);
            assertEquals(99, sC.getDistance(cC), 0.1);
    }

    @Test
    public void testInterchangeability() throws IllegalArgumentException {
        Coordinate sC = new SphericCoordinate(1,1,10);
        Coordinate cC = sC;
        sC = ((SphericCoordinate)cC).asCartesian();
        assertTrue(sC instanceof CartesianCoordinate);
        cC = sC;
        assertTrue(sC instanceof CartesianCoordinate);

    }


}
