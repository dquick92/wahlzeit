package org.wahlzeit.model;

public interface Coordinate {

    /**
     *
     * @param otherPoint
     * @return distance between <code>this</code> and <code>otherPoint</code>
     * @methodtype primitive
     */
    double getDistance(Coordinate otherPoint);

    boolean isEqual(Coordinate otherPoint);


}
