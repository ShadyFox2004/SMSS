package com.example;

public class Ship extends Module {
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

    // TODO Create tests
}
