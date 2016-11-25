package org.wahlzeit.model;

import java.io.Serializable;
import java.util.Vector;

/**
 * Created by daniel on 23.11.16.
 */
public abstract class AbstractCoordinate implements Coordinate,Serializable{

    /**
     *
     * @param otherPoint
     * @return shortest distance between <code>this</code> and <code>otherPoint</code>
     * @methodtype get
     */

    public double getDistance(Coordinate otherPoint){
        assertNotNull(otherPoint);
        return doGetDistance(otherPoint);
    }

    /**
     * tests if the two coordinates represent the same point in a cartesian coordinate system
     * @param otherPoint
     * @return
     */
    public boolean isEqual(Coordinate otherPoint){
        return this.asVector().equals(((AbstractCoordinate)otherPoint).asVector());

    }

    /**
     *
     * @return coordinate as Vector Interpretation
     */
    public abstract Vector<Double> asVector();

    /**
     * Calculates the direct distance between two coordinates with the formula d = sqrt(dX²+dY²+dZ²)
     * @return distance between <code>this</code> and <code>other</code>
     * @methodtype primitive
     */
    protected double doGetDistance(Coordinate otherPoint){
        Vector<Double> v1 = this.asVector();
        Vector<Double> v2 = ((AbstractCoordinate)otherPoint).asVector();

        double tmp = 0;
        for (int i = 0; i < v1.size(); i++){
            tmp += Math.pow(v2.get(i)-v1.get(i), 2);
        }

        return Math.sqrt(tmp);
    }

    protected void assertNotNull(Coordinate coord) throws NullPointerException{
        if (coord == null)
            throw new NullPointerException();
    }

}
