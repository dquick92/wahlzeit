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

        assertValidLat(latitude);
        assertValidLong(longitude);
        assertValidRadius(radius);

        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;

        assertClassInvariants();
    }

    public double getLatitude(){
        return this.latitude;
    }

    public void setLatitude(double latitude){
        assertValidLat(latitude);
        this.latitude = latitude;

    }

    public double getLongitude(){
        return this.longitude;
    }

    public void setLongitude(double longitude){
        assertValidLong(longitude);
        this.longitude = longitude;
    }

    public void setRadius(double radius){

        assertValidRadius(radius);
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
        double ret = this.radius*Math.sin(Math.toRadians(this.latitude))*
                Math.cos(Math.toRadians(this.longitude));

        return ret;
    }
    /**
     *
     * @methodtype helper
     */
    private double calcY(){
        double ret = this.radius*Math.sin(Math.toRadians(this.latitude))*
                Math.sin(Math.toRadians(this.longitude));

        return ret;
    }
    /**
     *
     * @methodtype helper
     */
    private double calcZ(){
        double ret = this.radius*Math.cos(Math.toRadians(this.latitude));
        return ret;
    }


    /**
     *
     * @methodtype get
     */
    @Override
    public double getDistance(Coordinate otherPoint) {
        assertNotNull(otherPoint);

        double ret = -1;

        //if otherPoint is a spheric coordinate:
        //  -- test for radius, if equal: return circular distance
        if (otherPoint instanceof SphericCoordinate) {
            SphericCoordinate other = (SphericCoordinate) otherPoint;
            if (other.getRadius() == this.radius) {

                ret = this.doGetDistance(other);
            }
        }

        //all other cases: return direct distance
        if (ret == -1)
            ret = super.getDistance(otherPoint);

        assert ret >= 0;
        assertClassInvariants();
        return ret;
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

    /**
     * @methodtype assertion
     */

    private void assertValidLat(double latitude) throws IllegalArgumentException{
        assertIsValidDouble(latitude);
        if (Math.abs(latitude) > 90)
            throw new IllegalArgumentException("Absolute latitude may not be greater than 90 degree!");
    }


    /**
     * @methodtype assertion
     */
    private void assertValidLong(double longitude) throws IllegalArgumentException{
        assertIsValidDouble(longitude);
        if (Math.abs(longitude) > 180)
            throw new IllegalArgumentException("Absolute longitude may not be greater than 180 degree!");
    }

    /**
     * @methodtype assertion
     */
    private void assertValidRadius(double radius) throws IllegalArgumentException{
        assertIsValidDouble(radius);
        if (radius < 0)
            throw new IllegalArgumentException("Radius must be greater 0!");
    }

    /**
     * @methodtype assertion
     */
    @Override
    protected void assertClassInvariants(){
        assertValidLat(this.latitude);
        assertValidLong(this.longitude);
        assertValidRadius(this.radius);
    }


}
