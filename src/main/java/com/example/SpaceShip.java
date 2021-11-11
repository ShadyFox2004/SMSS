package com.example;

public class SpaceShip {
    public SpaceShip() {
        this(DEFAULT_TAB_MODULES, DEFAULT_ANGULAR_MOMENTUM, DEFAULT_LINEAR_MOMENTUM);
    }

    public SpaceShip(Module[] tabModules, double angularMomentum, Vector linearMomentum) {
        setTabModules(tabModules);
        setAngularMomentum(angularMomentum);
        setLinearMomentum(linearMomentum);
    }

    private Module[] tabModules;
    private double angularMomentum;
    private Vector linearMomentum;
    private CenterOfMass centerOfMass;

    public static final Module[] DEFAULT_TAB_MODULES = new Module[0];
    public static final double DEFAULT_ANGULAR_MOMENTUM = 0;
    public static final Vector DEFAULT_LINEAR_MOMENTUM = new Vector();

    public CenterOfMass getCenterOfMass() {
        return this.centerOfMass;
    }

    public void setCenterOfMass() {
        CenterOfMass localCenterOfMass;
        double totalMass = 0;
        double totalX = 0;
        double totalY = 0;

        double currentMass;
        CenterOfMass currentCenterOfMass;

        for (Module module : tabModules) {
            currentCenterOfMass = module.getCenterOfMass();
            currentMass = currentCenterOfMass.getMass();
            totalX += currentCenterOfMass.getX() * currentMass;
            totalY += currentCenterOfMass.getY() * currentMass;
            totalMass += currentMass;
        }

        localCenterOfMass = new CenterOfMass(totalX / totalMass, totalY / totalMass, totalMass);

        this.centerOfMass = localCenterOfMass;
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

    public void addModule(Module module) {
        // TODO Make a better memory manager
        Module[] newTabModules = new Module[tabModules.length + 1];
        for (int i = 0; i < tabModules.length; i++) {
            newTabModules[i] = tabModules[i];
        }
        newTabModules[newTabModules.length - 1] = module;
        setTabModules(newTabModules);
        setCenterOfMass();
    }
}