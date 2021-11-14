package com.example;

public class Ship extends Module {
    private Module[] children;
    private Moment momentum;

    public Module[] getChildren() {
        return children;
    }

    // TODO Make the table setting logic
    // TODO Make the center off mass at the origin

    public void setChildren(Module[] children) {
        this.children = children;
    }

    public void updateCenterOfMass() {
        Vector centerOfMass = new Vector();
        this.setMass(0);

        for (Module module : children) {
            centerOfMass.add(module.getPosition().scalarProduct(module.getMass()));
            this.setMass(this.getMass()+module.getMass());
        }

        centerOfMass = centerOfMass.scalarProduct(1/this.getMass());

        for (Module module : children) {
            module.setPosition(module.getPosition().sub(centerOfMass));    
        }

        this.setPosition(this.getPosition().add(centerOfMass));
    }
}
