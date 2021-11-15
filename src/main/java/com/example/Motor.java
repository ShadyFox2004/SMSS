package com.example;

public class Motor extends Module {
    public Motor(Vector position, double mass, double direction, double force) {
        super(position, mass, direction);
        this.setForce(force);
        this.setPower(10);
        //TODO Auto-generated constructor stub
    }

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
        System.out.println("Motor.calculateMomentImpact()");
        System.out.println(linearImpulse);

        Vector normal = this.getPosition().rotate(Math.PI);
        angularImpulse = linearImpulse.projectOn(normal).getMagnitude()*this.getPosition().getMagnitude();
        angle = Vector.getAngleBetween(normal, linearImpulse);

        if (angle > Math.PI/2) {
            angularImpulse = -angularImpulse;
        }

        // Torque calculation
        //angle = Vector.getAngleBetween(this.getPosition(), linearImpulse);
        //angularImpulse = linearImpulse.getMagnitude()*angle*this.getPosition().getMagnitude();
        //if (Vector.getAngleBetween(this.getPosition().rotate(Math.PI), linearImpulse) > Math.PI / 2.0){
        //    angularImpulse = -angularImpulse;
        //}
        impact = new Moment(linearImpulse, angularImpulse);
        return impact;
    }
}
