package com.example;

import java.util.Objects;

public class Ship extends Module {
    public Ship(String id, Vector position, double mass, double direction) {
        super(id, position, mass, direction);
        this.setPosition(position);
        this.setChildren(new Module[0]);
        //TODO Auto-generated constructor stub
    }

    private Moment momentum = new Moment();

    public Moment getMomentum() {
		return momentum;
	}

	public void setMomentum(Moment momentum) {
		this.momentum = momentum;
	}

	public Ship(String id, Vector position, double mass, double direction, Moment momentum) {
		super(id, position, mass, direction);
		this.momentum = momentum;
	}

	private Module[] children;

    public Module[] getChildren() {
        return children;
    }

    public void setChildren(Module[] children){
        this.children = children;
    }

    public void addChildren(Module child) {
       Module[] newChildren =  new Module[this.getChildren().length+1];

       for (int i = 0; i < this.getChildren().length; i++) {
           newChildren[i] = this.getChildren()[i];           
       }

       newChildren[this.getChildren().length] = child;

       this.setChildren(newChildren);
       
       updateCenterOfMass();
    }

    public void updateCenterOfMass() {
        Vector centerOfMass = new Vector();
        this.setMass(0);

        for (Module module : children) {
            centerOfMass.add(module.getPosition().scalarProduct(module.getMass()));
            this.setMass(this.getMass() + module.getMass());
        }

        
        centerOfMass = centerOfMass.scalarProduct(1 / this.getMass());

        for (Module module : children) {
            module.setPosition(module.getPosition().sub(centerOfMass));
        }

        this.setPosition(this.getPosition().add(centerOfMass));
    }

    public Moment getImpulse() {
        Moment impulse = new Moment();

        for (Module module : children) {
            impulse = impulse.add(module.calculateMomentImpact(this));
        }

        // Rotate impulse to be global
        impulse.setLinear(impulse.getLinear().rotate(this.getDirection()));

        return impulse;
    }

    public void computePhysics(double seconds) {
        Moment impulse = this.getImpulse();
        impulse = impulse.scalar(seconds);
        this.setMomentum(this.getMomentum().add(impulse));
        this.setPosition(this.getPosition().add(this.getMomentum().getLinear()));
        this.setDirection(this.getDirection() + impulse.getAngular());
    }
	
    public Module getToModuleById(String id){
    	for (Module module : children) {
            if(id.equals(module.getId())){
                return module;
            }
        }
        return null;
    }
    // TODO Create tests
}
