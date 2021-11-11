package com.example;

import java.util.ArrayList;

public class Body {

    public Body() {
        this(DEFAULT_LOCAL_POSITION, DEFAULT_ANGLE, DEFAULT_PARENT);
    }
    
    public Body(Point localPosition, double angle, Body parent) {
        this.localPosition = localPosition;
        this.angle = angle;
        this.parent = parent;
        this.children = DEFAULT_CHILDREN;
    }

    private static Point DEFAULT_LOCAL_POSITION = new Point();
    private static double DEFAULT_ANGLE = 0.0;
    private static Body DEFAULT_PARENT = null;
    private static ArrayList<Body> DEFAULT_CHILDREN = new ArrayList<Body>(0);

    private Point localPosition;
    private double angle;
    private Body parent;
    private ArrayList<Body> children;

    private void addChild(Body child) {
        children.add(child);
    }

    private void removeChild(Body child) {
        children.remove(child);
    }

    public Point getLocalPosition() {
        return localPosition;
    }

    public void setLocalPosition(Point localPosition) {
        this.localPosition = localPosition;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public Body getParent() {
        return parent;
    }

    public void setParent(Body parent) {
        this.parent = parent;
    }

}