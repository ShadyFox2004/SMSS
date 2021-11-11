package com.example;

public class CenterOfMass extends Point {
    
    public CenterOfMass() {
        this(Point.DEFAULT_X,
        Point.DEFAULT_Y,
        DEFAULT_MASS);
    }

    public CenterOfMass(double x, double y, double mass) {
        super(x, y);
        setMass(mass);
    }

    private double mass;

    public static final double DEFAULT_MASS = 1;
    public static final double MIN_MASS = 0;

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        if(!CenterOfMass.massIsValid(mass))
            try {
                throw(new Exception("mass is below 0 : "+ mass));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        this.mass = mass;
    }

    @Override
    public String toString() {
        return "CenterOfMass [mass=" + this.getMass() + ", x=" + this.getX() + ", y=" + this.getY() + "]";
    }

    // TODO Create tests
    
    // TODO Create validators for mass ( NOT REALLY GOOD)

    public static boolean massIsValid(double mass) {
        return mass > MIN_MASS;
    }

    // TODO Create special methods

    public static void main(String[] args) {
        new CenterOfMass(2, 2, -1);
    }
}
