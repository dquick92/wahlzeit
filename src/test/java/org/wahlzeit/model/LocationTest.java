package org.wahlzeit.model;

/**
 * Created on 28.10.16.
 */
import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LocationTest {

    public Coordinate tmpCoordinate;

    @Before
    public void setTmpCoordinate() throws InvalidArgumentException {
        tmpCoordinate = new SphericCoordinate(5.4321, 5.1234, SphericCoordinate.EARTH_RADIUS);
    }

    @Test
    public void testGetDistance() throws InvalidArgumentException {
        Location tmpLocation = new Location(tmpCoordinate);

        //same Location, must be 0
        assertEquals(0, tmpLocation.getDistance(tmpLocation), 0);

        //different Locations, must be > 0
        assertTrue(tmpLocation.getDistance(new Location(new SphericCoordinate(0.0, 0.0, SphericCoordinate.EARTH_RADIUS))) > 0);
    }
}
