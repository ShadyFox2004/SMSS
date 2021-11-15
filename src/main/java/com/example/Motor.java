package com.example;

public class Motor extends Module {
    private double force;
    private double power;
    private double consomation;

    public double getForce() {
        return force;
    }

    public void setForce(double force) {
        this.force = force;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getConsomation() {
        return consomation;
    }

    public void setConsomation(double consomation) {
        this.consomation = consomation;
    }

    @Override
    public Moment calculateMomentImpact(Module parent) {
        // TODO Calculate Physics
        // TODO Make the context global
        return super.calculateMomentImpact(parent);
    }
}
