package com.example;

import java.util.Scanner;

public class Motor extends Module {
    public Motor(String id, Vector position, double mass, double direction) {
        super(id, position, mass, direction);
        this.setForce(DEFAULT_FORCE);
        this.setPower(DEFAULT_POWER);
        this.setConsomation(DEFAULT_CONSOMATION);
        // TODO Auto-generated constructor stub
    }

    private double force;
    private double power;
    private double consomation;

    public static final double DEFAULT_FORCE = 10;
    public static final double DEFAULT_POWER = 0;
    public static final double DEFAULT_CONSOMATION = 0;

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
        linearImpulse = new Vector(this.getForce() * this.getPower(), 0).rotate(this.getDirection());

        // Rotation calculation
        Vector normal = this.getPosition().rotate(Math.PI);
        angularImpulse = linearImpulse.projectOn(normal).getMagnitude() * this.getPosition().getMagnitude();
        angle = Vector.getAngleBetween(normal, linearImpulse);

        if (angle > Math.PI / 2) {
            angularImpulse = -angularImpulse;
        }

        impact = new Moment(linearImpulse, angularImpulse);
        return impact;
    }

    @Override
    public String eval(Scanner sc) {
        String command = sc.next();
        if (command.equals("set")) {
            command = sc.next();
            if (command.equals("thrust")) {
                command = sc.next();
                double thrust = Double.parseDouble(command);
                if (thrust < 1 || thrust >= 0) {
                    this.setPower(thrust);
                    return (this.getId() + " thrust set to " + this.getPower());
                }
            } else if (command.equals("direction")) {
                command = sc.next();
                double direction = Double.parseDouble(command);
                this.setDirection(direction);
                return (this.getId() + " direction set to " + this.getDirection());
            }
        } else if (command.equals("get")) {
            command = sc.next();
            if (command.equals("thrust")) {
                return (this.getId() + " thrust set to " + this.getPower());
            }
        }
        return "command not found...";
    }
}
