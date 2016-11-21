package org.wahlzeit.model;

import java.util.Vector;

/**
 * Created by daniel on 14.11.16.
 */
public class CartesianCoordinate implements Coordinate{

    private double x = 0,y = 0,z = 0;

    public CartesianCoordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getZ(){
        return z;
    }

    /**
     *
     * @methodtype get
     */
    public double getDistance(Coordinate otherPoint){

        CartesianCoordinate other;

        if (otherPoint instanceof SphericCoordinate)
            other = ((SphericCoordinate)otherPoint).asCartesian();
        else
            other = (CartesianCoordinate) otherPoint;

        return this.doGetDistance(other);
    }


    /**
     * Calculates the direct distance between two coordinates with the formula d = sqrt(dX²+dY²+dZ²)
     * @return distance between <code>this</code> and <code>other</code>
     * @methodtype get
     * @methodproperties primitive
     */
    public double doGetDistance(CartesianCoordinate other){

        double xDiff = other.getX()-this.x;
        double yDiff = other.getY()-this.y;
        double zDiff = other.getZ()-this.z;

        return Math.sqrt(xDiff*xDiff+yDiff*yDiff+zDiff*zDiff);

    }
}
