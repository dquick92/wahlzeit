package org.wahlzeit.model;

import java.io.Serializable;

/**
 * Created on 28.10.16.
 */

public class Location implements Serializable{

    public SphericCoordinate coordinate;

    public Location(){
        this.coordinate = null;
    }

    public Location(SphericCoordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setCoordinate(SphericCoordinate coordinate){
        this.coordinate = coordinate;
    }

    public SphericCoordinate getCoordinate(){
        return this.coordinate;
    }

    public double getDistance(Location otherLocation){
        return this.coordinate.getDistance(otherLocation.getCoordinate());
    }

}
