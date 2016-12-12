package org.wahlzeit.model;


import java.util.Vector;

public class CartesianCoordinate extends AbstractCoordinate {

    private double x = 0, y = 0, z = 0;

    public CartesianCoordinate(double x, double y, double z) {


        this.x = x;
        this.y = y;
        this.z = z;
        assertClassInvariants();
    }

    public CartesianCoordinate(Vector<Double> v){

        try {
            this.x = v.get(0);
            this.y = v.get(1);
            this.z = v.get(2);
        } catch (Exception e) {
            throw new IllegalArgumentException("The Vector v is not valid or too small. Expected size: 3");
        }
        assertClassInvariants();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public Vector<Double> asVector() {
        Vector<Double> ret = new Vector<>();
        ret.addElement(x);
        ret.addElement(y);
        ret.addElement(z);
        return ret;
    }

    /**
     * @methodtype assertion
     */
    @Override
    protected void assertClassInvariants() {
        assertIsValidDouble(x);
        assertIsValidDouble(y);
        assertIsValidDouble(z);
    }

}
