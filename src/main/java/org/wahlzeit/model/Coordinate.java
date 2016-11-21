package org.wahlzeit.model;

import java.util.Vector;

public interface Coordinate {

    /**
     *
     * @param otherPoint
     * @return distance between <code>this</code> and <code>otherPoint</code>
     * @methodtype primitive
     */
    double getDistance(Coordinate otherPoint);

}
