package com.example;

public class Module {
    // TODO Create constructors

    private Vector position;
    private double mass;
    private double direction;

    // TODO Create default parameters

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public Moment calculMomentImpact(Module parent) {
        return new Moment();
    }
}