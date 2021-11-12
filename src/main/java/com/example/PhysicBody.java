package com.example;

public class PhysicBody extends Body {
    private double mass;
    private static final double DEFAULT_MASS = 0.0;

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    @Override
    public void addChild(Body child) {
        super.addChild(child);
        if (child.getClass() == Body.class) {

        }
    }

    // Recalculate offset, inform superclass.
    public void updateCenterOfMass() {
        if (this.getParent() != null) {
            ((PhysicBody) this.getParent()).updateCenterOfMass();
        }
        // Find Center offsetCenterOfMass

    }

    

    public Point findCenterOfMassOffset() {
        double totalMass = 0;
        double totalX = 0;
        double totalY = 0;

        for (Body body : super.getChildren()) {
            if (body.getClass() == PhysicBody.class) {
                PhysicBody physicBody = ((PhysicBody) body);
                double localMass = physicBody.getMass();
                double localX = physicBody.getLocalPosition().getX();
                double localY = physicBody.getLocalPosition().getY();
                
                totalMass += localMass;
                totalX += localMass * localX;
                totalY += localMass * localY;
            }            
        }

        totalX = totalX / totalMass;  // Won't never be 0
        totalY = totalY / totalMass;
        Point offset = new Point(totalX, totalY);
        this.setMass(totalMass);
        return offset;
    }
    
    public void offsetCenterOfMass(Vector displacement) {
        
    }
}
