package org.wahlzeit.model;

/**
 * Created on 28.10.16.
 */
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


public class LocationTest {

    public Coordinate tmpCoordinate;

    @Before
    public void setTmpCoordinate(){
        tmpCoordinate = new Coordinate(5.4321, 5.1234);
    }

    @Test
    public void testSetCoordinate() {
        Location tmpLocation = new Location();
        tmpLocation.setCoordinate(tmpCoordinate);
        assertEquals(5.4321, tmpLocation.coordinate.getLatitude(), 0);
        assertEquals(5.1234, tmpLocation.coordinate.getLongitude(), 0);
    }

    @Test
    public void testGetCoordinate(){
        Location tmpLocation = new Location();
        tmpLocation.coordinate = tmpCoordinate;
        assertEquals(5.4321, tmpLocation.getCoordinate().getLatitude(), 0);
        assertEquals(5.1234, tmpLocation.getCoordinate().getLongitude(), 0);
    }

    @Test
    public void testConstructor(){
        Location tmpLocation = new Location(tmpCoordinate);
        assertEquals(5.4321, tmpLocation.getCoordinate().getLatitude(), 0);
        assertEquals(5.1234, tmpLocation.getCoordinate().getLongitude(), 0);
    }

    @Test
    public void testGetDistance(){
        Location tmpLocation = new Location(tmpCoordinate);

        //same Location, must be 0
        assertEquals(0, tmpLocation.getDistance(tmpLocation), 0);

        //different Locations, must be > 0
        assertTrue(tmpLocation.getDistance(new Location(new Coordinate(0.0, 0.0))) > 0);
    }
}
