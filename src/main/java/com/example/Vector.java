package com.example;

public class Vector {
    public Vector(Point tail, Point head) {
        this(head.getX() - tail.getX(), head.getY() - tail.getY());
    }

    public Vector() {
        this(DEFAULT_I, DEFAULT_Y);
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
        return String.format("Vector [i= %f, j= %f ]", this.getI(), this.getJ());
    }

    public Vector add(Vector otherVector) {
        return new Vector(this.getI() + otherVector.getI(), this.getJ() + otherVector.getJ());
    }

    public double dotProduct(Vector otherVector) {
        return this.getI() * otherVector.getI() + this.getJ() * otherVector.getJ();
    }

    public Vector scalarProduct(double scalar) {
        return new Vector(this.getI() * scalar, this.getJ() * scalar);
    }

    public static void rotateAll(Vector[] vectors, double angle) {
        final double cos = Math.cos(angle);
        final double sin = Math.sin(angle);

        for (Vector vector : vectors) {
            vector.rotateByConSin(cos, sin);
        }
    }

    public Vector rotate(double angle) {
        final double cosOfAngle = Math.cos(angle);
        final double sinOfAngle = Math.sin(angle);

        return this.rotateByConSin(cosOfAngle, sinOfAngle);
    }

    public Vector rotateByConSin(double cos, double sin) {

        double oldI = this.getI();
        double oldJ = this.getJ();

        this.setI(cos * oldI - sin * oldJ);
        this.setJ(sin * oldI + cos * oldJ);
        return this;
    }

    public Vector projectOn(Vector projectionLine) {
        return projectionLine.scalarProduct(this.dotProduct(projectionLine) / projectionLine.dotProduct(projectionLine));
    }

    public double getMagnitude() {
        return Math.sqrt(this.i * this.i + this.j * this.j);
    }

    public static double getAngleBetween(Vector firstVector, Vector secondVector) {
        return Math.acos(
                firstVector.dotProduct(secondVector) / (firstVector.getMagnitude() * secondVector.getMagnitude()));
    }
}