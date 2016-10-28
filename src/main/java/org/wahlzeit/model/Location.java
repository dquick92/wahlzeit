package org.wahlzeit.model;

/**
 * Created on 28.10.16.
 */

public class Location {

    public Coordinate coordinate;

    public Location(){
        this.coordinate = null;
    }

    public Location(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Location(double latitude, double longitude){
        this.coordinate = new Coordinate(latitude, longitude);
    }

    public void setCoordinate(Coordinate coordinate){
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate(){
        return this.coordinate;
    }

    public double getDistance(Location otherLocation){
        return this.coordinate.getDistance(otherLocation.getCoordinate());
    }

}
