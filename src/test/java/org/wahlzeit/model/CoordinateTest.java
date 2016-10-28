package org.wahlzeit.model;

/**
 * Created on 28.10.16.
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class CoordinateTest {

    @Test
    public void testSetLatitude() {
        Coordinate tmpCoord = new Coordinate();
        tmpCoord.setLatitude(5.4321);
        assertEquals(5.4321, tmpCoord.getLatitude(), 0);
    }

    @Test
    public void testSetLongitude(){
        Coordinate tmpCoord = new Coordinate();
        tmpCoord.setLongitude(5.1234);
        assertEquals(5.1234, tmpCoord.getLongitude(),0);
    }

    @Test
    public void testConstructor(){
        Coordinate tmpCoord = new Coordinate(5.4321,5.1234);
        assertEquals(5.1234, tmpCoord.getLongitude(),0);
        assertEquals(5.4321, tmpCoord.getLatitude(),0);
    }

    @Test
    public void testGetDistance(){

        Coordinate tmpCoord = new Coordinate(5.4321,5.1234);

        //same point, should be 0
        assertEquals(0, tmpCoord.getDistance(tmpCoord), 0);

        //random point, distance must be > 0
        assertTrue(tmpCoord.getDistance(25.321, -50.432) > 0);

        //sample point with given result
        assertEquals(4102177.0697, tmpCoord.getDistance(-171.1234, -83.4321), 0.1);
    }


}
