package com.example;

public class Moment {

    public Moment(){
        this(DEFAULT_LINEAR, DEFAULT_ANGULAR);
    }

    public Moment(Vector linear, double angular) {
        this.linear = linear;
        this.angular = angular;
    }

    private Vector linear;
    private double angular;

    public static final Vector DEFAULT_LINEAR = new Vector();
    public static final double DEFAULT_ANGULAR = 0;

    public Vector getLinear() {
        return linear;
    }
    
    public void setLinear(Vector linear) {
        this.linear = linear;
    }

    public double getAngular() {
        return angular;
    }
    
    public void setAngular(double angular) {
        this.angular = angular;
    }

    public Moment add(Moment otherMoment){
        Moment sum;

        Vector linearSum = this.getLinear().add(otherMoment.getLinear());
        double angularSum = this.getAngular() + otherMoment.getAngular();
        sum = new Moment(linearSum, angularSum);

        return sum;
    }

    public Moment scalar(double scalar) {
        Moment product;

        double angularProduct = this.getAngular()* scalar;
        product = new Moment(this.getLinear().scalarProduct(scalar), angularProduct);

        return product;
    }

    @Override
    public String toString() {
        return "Moment [angular=" + angular + ", linear=" + linear + "]";
    }
}
