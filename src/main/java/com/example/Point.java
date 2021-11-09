package com.example;
public class Point {
    public Point() {
        this(DEFAULT_X,
        DEFAULT_Y);
    }

    public Point(double x, double y) {
        setX(x);
        setY(y);
    }

    private double x;
    private double y;

    public static final double DEFAULT_X = 0;
    public static final double DEFAULT_Y = 0;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }

    // TODO Create validators

    // TODO Create special methods
}