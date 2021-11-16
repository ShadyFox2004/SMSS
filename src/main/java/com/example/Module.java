package com.example;

import java.util.Scanner;

public class Module {
    // TODO Create constructors

    public Module(String id,Vector position, double mass, double direction) {
        this.id = id;
        this.position = position;
        this.mass = mass;
        this.direction = direction;
    }

    private Vector position;
    private double mass;
    private double direction;
    private String id; 

    // TODO Create default parameters

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Vector getPosition() {
        return this.position;
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

    public Moment calculateMomentImpact(Module parent) {
        return new Moment();
    }

    public String eval(Scanner sc) {
        String command = sc.next();
		if (command.equals("set")) {
            return "set";
        } else if (command.equals("get")) {
            return "get";
        }
		return "command not found...";
    }
}
