package com.example;

public class CenterOfMass extends Point {
    public CenterOfMass() {
        setMass(DEFAULT_MASS);
    }

    public CenterOfMass(double x, double y, double mass) {
        super(x, y);
        setMass(mass);
    }

    private double mass;

    public static final double DEFAULT_MASS = 0;

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    @Override
    public String toString() {
        return "CenterOfMass [mass=" + this.getMass() + ", x=" + this.getX() + ", y=" + this.getY() + "]";
    }

    // TODO Create validators

    // TODO Create special methods
}
