package com.example;

public class SpaceShip {
    public SpaceShip() {
        this(DEFAULT_TAB_MODULES,
        DEFAULT_ANGULAR_MOMENTUM,
        DEFAULT_LINEAR_MOMENTUM,
        DEFAULT_CENTER_OF_MASS);
    }
    
    public SpaceShip(Module[] tabModules, double angularMomentum, Vector linearMomentum, CenterOfMass centerOfMass) {
        setTabModules(tabModules);
        setAngularMomentum(angularMomentum);
        setLinearMomentum(linearMomentum);
        setCenterOfMass(centerOfMass);
    }

    

    private Module[] tabModules;
    private double angularMomentum;
    private Vector linearMomentum;
    private CenterOfMass centerOfMass;

    public static final Module[] DEFAULT_TAB_MODULES = new Module[0];
    public static final double DEFAULT_ANGULAR_MOMENTUM = 0;
    public static final Vector DEFAULT_LINEAR_MOMENTUM = new Vector();
    public static final CenterOfMass DEFAULT_CENTER_OF_MASS = new CenterOfMass();

    public CenterOfMass getCenterOfMass() {

        return this.centerOfMass;
    }

    public void setCenterOfMass(CenterOfMass centerOfMass) {
        this.centerOfMass = centerOfMass;
    }

    public Module[] getTabModules() {
        return tabModules;
    }

    public void setTabModules(Module[] tabModules) {
        this.tabModules = tabModules;
    }

    public double getAngularMomentum() {
        return this.angularMomentum;
    }

    public void setAngularMomentum(double angularMomentum) {
        this.angularMomentum = angularMomentum;
    }

    public Vector getLinearMomentum() {
        return this.linearMomentum;
    }

    public void setLinearMomentum(Vector linearMomentum) {
        this.linearMomentum = linearMomentum;
    }
}