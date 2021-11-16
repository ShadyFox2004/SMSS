package com.example;

public class Vector {
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

    public Vector sub(Vector otherVector) {
        return this.add(otherVector.getInverse());
    }

    public double dotProduct(Vector otherVector) {
        return this.getI() * otherVector.getI() + this.getJ() * otherVector.getJ();
    }

    public Vector scalarProduct(double scalar) {
        return new Vector(this.getI() * scalar, this.getJ() * scalar);
    }

    public Vector divideByScalar(double scalar) {
        return new Vector(this.getI() / scalar, this.getJ() / scalar);
    }

    public Vector rotate(double angle) {
        final double cosOfAngle = Math.cos(angle);
        final double sinOfAngle = Math.sin(angle);

        return this.rotateByCosSin(cosOfAngle, sinOfAngle);
    }

    public Vector rotateByCosSin(double cos, double sin) {
        return new Vector(cos * this.getI() - sin * this.getJ(),
        sin * this.getI() + cos * this.getJ());
    }

    public Vector projectOn(Vector projectionLine) {
        return projectionLine
                .scalarProduct(this.dotProduct(projectionLine) / projectionLine.dotProduct(projectionLine));
    }

    public double getMagnitude() {
        return Math.sqrt(this.i * this.i + this.j * this.j);
    }

    public static double getAngleBetween(Vector firstVector, Vector secondVector) {
        double answer = Math.acos(
                firstVector.dotProduct(secondVector) / (firstVector.getMagnitude() * secondVector.getMagnitude()));
        if(Double.NaN == answer){
            return 0;
        }
        return answer;
    }

    public Vector getInverse() {
        return this.scalarProduct(-1.0);
    }
}