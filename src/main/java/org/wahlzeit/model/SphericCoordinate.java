package org.wahlzeit.model;




import java.util.Vector;


/**
 * Created on 28.10.16.
 */

public class SphericCoordinate extends AbstractCoordinate{

    public static final int EARTH_RADIUS = 6371;


    private double latitude;
    private double longitude;
    private double radius;

    public SphericCoordinate(){
        latitude = 0.0;
        longitude = 0.0;
        radius = EARTH_RADIUS;
    }

    public SphericCoordinate(double latitude, double longitude, double radius) throws
            IllegalArgumentException {
        if (Math.abs(latitude) > 90 || Math.abs(longitude) > 180 || radius < 0 )
            throw new IllegalArgumentException();

        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    public double getLatitude(){
        return this.latitude;
    }

    public void setLatitude(double latitude) throws IllegalArgumentException{
        if (Math.abs(latitude) > 90)
            throw new IllegalArgumentException();

        this.latitude = latitude;
    }

    public double getLongitude(){
        return this.longitude;
    }

    public void setLongitude(double longitude) throws IllegalArgumentException {
        if (Math.abs(longitude) > 90)
            throw new IllegalArgumentException();
        this.longitude = longitude;
    }

    public void setRadius(double radius) throws IllegalArgumentException {
        if (radius < 0)
            throw new IllegalArgumentException();

        this.radius = radius;
    }

    public double getRadius(){ return this.radius; }

    /**
     * get the Coordinate as Cartesian Vector Interpretation
     * @methodtype get
     */
    public Vector<Double> asVector(){
        Vector<Double> ret = new Vector<>();
        ret.addElement(calcX());
        ret.addElement(calcY());
        ret.addElement(calcZ());
        return ret;
    }

    /**
     *
     * @methodtype helper
     */
    private double calcX(){
        return this.radius*Math.sin(Math.toRadians(this.latitude))*
                Math.cos(Math.toRadians(this.longitude));
    }
    /**
     *
     * @methodtype helper
     */
    private double calcY(){
        return this.radius*Math.sin(Math.toRadians(this.latitude))*
                Math.sin(Math.toRadians(this.longitude));
    }
    /**
     *
     * @methodtype helper
     */
    private double calcZ(){
        return this.radius*Math.cos(Math.toRadians(this.latitude));
    }


    /**
     *
     * @methodtype get
     */
    @Override
    public double getDistance(Coordinate otherPoint) {
        assertNotNull(otherPoint);
        //if otherPoint is a spheric coordinate:
        //  -- test for radius, if equal: return circular distance
        if (otherPoint instanceof SphericCoordinate) {
            SphericCoordinate other = (SphericCoordinate) otherPoint;
            if (other.getRadius() == this.radius) {
                return this.doGetDistance(other);
            }
        }

        //all other cases: return direct distance
        return super.getDistance(otherPoint);
    }


    /**
     *calculates the distance between two Points on the earthern sphere
     *using the Vincenty Formula with the atan2-Function to preserver large rounding numbers
     *source: https://en.wikipedia.org/wiki/Great-circle_distance
     *
     *@return distance between this coordinate and the other coordinate in kilometers
     *
     *@methodtype primitive
     *
     */
    protected double doGetDistance(SphericCoordinate otherPoint){
        double radLongitude = Math.toRadians(this.longitude);
        double radOtherLongitude = Math.toRadians(otherPoint.getLongitude());
        double radLatitude = Math.toRadians(this.latitude);
        double radOtherLatitude = Math.toRadians(otherPoint.getLatitude());

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

        double distance = radius*deltaSigma;

        return distance;
    }


}
