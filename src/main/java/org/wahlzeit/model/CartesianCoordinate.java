package org.wahlzeit.model;

import org.wahlzeit.utils.Cache;

import java.util.Vector;

public class CartesianCoordinate extends AbstractCoordinate {

    private static Cache<CartesianCoordinate> storage = new Cache<CartesianCoordinate>();

    private double x = 0, y = 0, z = 0;


    public static CartesianCoordinate getInstance(double x, double y, double z){
        return storage.find(new CartesianCoordinate(x, y, z));
    }

    public static CartesianCoordinate getInstance(Vector<Double> v){
        return storage.find(new CartesianCoordinate(v));
    }

    private CartesianCoordinate(double x, double y, double z) {
        assertIsValidDouble(x);
        assertIsValidDouble(y);
        assertIsValidDouble(z);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    private CartesianCoordinate(Vector<Double> v){

        try {
            assertIsValidDouble(v.get(0));
            assertIsValidDouble(v.get(1));
            assertIsValidDouble(v.get(2));
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
