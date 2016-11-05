package org.wahlzeit.model;


/**
 * Created on 28.10.16.
 */

public class Coordinate {

    public static final int EARTH_RADIUS = 6371;


    private double latitude;
    private double longitude;

    public Coordinate(){
        latitude = 0.0;
        longitude = 0.0;
    }

    public Coordinate(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude(){
        return this.latitude;
    }

    public void setLatitude(double latitude){
        this.latitude = latitude;
    }

    public double getLongitude(){
        return this.longitude;
    }

    public void setLongitude(double longitude){
        this.longitude = longitude;
    }

    public double getDistance(Coordinate otherPoint){
        return getDistance(otherPoint.getLatitude(), otherPoint.getLongitude());
    }

    /*calculate the distance between two Points on the earthern sphere
     *using the Vincenty Formula with the atan2-Function to preserver large rounding numbers
     *source: https://en.wikipedia.org/wiki/Great-circle_distance
     *
     *return: distance between this coordinate and the other coordinate in kilometers
     */
    public double getDistance(double latitudeOtherPoint, double longitudeOtherPoint){
        double radLongitude = Math.toRadians(this.longitude);
        double radOtherLongitude = Math.toRadians(longitudeOtherPoint);
        double radLatitude = Math.toRadians(this.latitude);
        double radOtherLatitude = Math.toRadians(latitudeOtherPoint);

        double deltaLambda = Math.abs(radLongitude-radOtherLongitude);

        double numeratorFirstTerm = Math.cos(radOtherLatitude)*Math.sin(deltaLambda);
        double numeratorSecondTerm = Math.cos(radLatitude)*Math.sin(radOtherLatitude)-
                Math.sin(radLatitude)*Math.cos(radOtherLatitude)*Math.cos(deltaLambda);

        double atan2Y = Math.sqrt(numeratorFirstTerm*numeratorFirstTerm+
                numeratorSecondTerm*numeratorSecondTerm);

        double atan2X = Math.sin(radLatitude)*Math.sin(radOtherLatitude)+
                Math.cos(radLatitude)*Math.cos(radOtherLatitude)*Math.cos(deltaLambda);

        //error case, Vincenties function undefined
        if (atan2Y == 0 && atan2X == 0){
            return 0;
        }

        double deltaSigma = Math.atan2(atan2Y, atan2X);

        double distance = EARTH_RADIUS*deltaSigma;

        return distance;
    }



}
