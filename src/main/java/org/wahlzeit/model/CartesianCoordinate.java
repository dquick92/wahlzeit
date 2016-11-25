package org.wahlzeit.model;


import java.util.Vector;

public class CartesianCoordinate extends AbstractCoordinate {

    private double x = 0,y = 0,z = 0;

    public CartesianCoordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public CartesianCoordinate(Vector<Double> v) throws IllegalArgumentException{
        try {
            this.x = v.get(0);
            this.y = v.get(1);
            this.z = v.get(2);
        }catch(Exception e){
            throw new IllegalArgumentException();
        }
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

    @Override
    public Vector<Double> asVector(){
        Vector<Double> ret = new Vector<>();
        ret.addElement(x);
        ret.addElement(y);
        ret.addElement(z);
        return ret;
    }

}
