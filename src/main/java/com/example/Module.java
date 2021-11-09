package com.example;

public class Module {
    public Module() {
        setDirection(DEFAULT_DIRECTION);
        setCenterOfMass(DEFAULT_CENTER_OF_MASS);
    }

    public Module(double direction, CenterOfMass centerOfMass) {
        setDirection(direction);
        setCenterOfMass(centerOfMass);
    }
    
    private double direction;
    private CenterOfMass centerOfMass;

    public static final double DEFAULT_DIRECTION = 0;
    public static final CenterOfMass DEFAULT_CENTER_OF_MASS = new CenterOfMass();

    public double getDirection() {
        return this.direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public CenterOfMass getCenterOfMass() {
        return this.centerOfMass;
    }

    public void setCenterOfMass(CenterOfMass centerOfMass) {
        this.centerOfMass = centerOfMass;
    }

    @Override
    public String toString() {
        return "Module [centerOfMass=" + centerOfMass + ", direction=" + direction + "]";
    }

    public static void main(String[] args) {
        Module myModule = new Module();
        System.out.println(myModule);
    }
}