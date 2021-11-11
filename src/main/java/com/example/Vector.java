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
        return "Vector [i=" + this.getI() + ", j=" + this.getJ() + "]";
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
        final double cosOfAngle = Math.cos(angle);
        final double sinOfAngle = Math.sin(angle);

        for (Vector vector : vectors) {
            vector.setI(cosOfAngle * vector.getI() + sinOfAngle * vector.getJ());
            vector.setJ(sinOfAngle * vector.getI() - cosOfAngle * vector.getJ());
        }
    }

    public Vector rotate(double angle) {
        final double cosOfAngle = Math.cos(angle);
        final double sinOfAngle = Math.sin(angle);

        this.setI(cosOfAngle * this.getI() + sinOfAngle * this.getJ());
        this.setJ(sinOfAngle * this.getI() - cosOfAngle * this.getJ());
        return this;
    }

    public Vector vectorProjection(Vector projectionLine) {
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