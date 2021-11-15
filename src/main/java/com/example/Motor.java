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
        Moment impact;

        double angularImpulse;
        Vector linearImpulse;

        // Thrust calculation
        double angle;
        linearImpulse = new Vector(this.getForce()*this.getPower(),0).rotate(this.getDirection());
        

        // Torque calculation
        angle = Vector.getAngleBetween(this.getPosition(), linearImpulse);
        angularImpulse = linearImpulse.getMagnitude()*angle*this.getPosition().getMagnitude();

        impact = new Moment(linearImpulse, angularImpulse);

        return impact;
    }
}
