package com.example;

public class Vector {
    public Vector() {
        setI(DEFAULT_I);
        setJ(DEFAULT_Y);
    }

    public Vector(double i, double j) {
        setI(i);
        setJ(j);
    }

    private double i;
    private double j;

    public static final double DEFAULT_I = 0;
    public static final double DEFAULT_Y = 0;

    public double getI() {
        return i;
    }

    public void setI(double i) {
        this.i = i;
    }

    public double getJ() {
        return j;
    }

    public void setJ(double j) {
        this.j = j;
    }

    @Override
    public String toString() {
        return "Vector [i=" + this.getI() + ", j=" + this.getJ() + "]";
    }

    // TODO Create validators

    public Vector add(Vector otherVector) {
        return new Vector(this.getI() + otherVector.getI(), this.getJ() + otherVector.getJ());
    }

    public double dotProduct(Vector otherVector) {
        return this.getI()*otherVector.getI() + this.getJ()*otherVector.getJ();
    }

    // TODO Create special methods
}