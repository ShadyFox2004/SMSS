package com.example;

public class Moment {

    public Moment(){
        this(DEFAULT_LINEAR, DEFAULT_ANGULAR);
    }

    public Moment(final Vector linear, final double angular) {
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
    
    public void setLinear(final Vector linear) {
        this.linear = linear;
    }

    public double getAngular() {
        return angular;
    }
    
    public void setAngular(final double angular) {
        this.angular = angular;
    }

    /**
     * Adds the moment together
     * @param otherMoment
     * @return sum
     */
    public Moment add(final Moment otherMoment){
        Moment sum;

        final Vector linearSum = this.getLinear().add(otherMoment.getLinear());
        final double angularSum = this.getAngular() + otherMoment.getAngular();
        sum = new Moment(linearSum, angularSum);

        return sum;
    }

    /**
     * Multiply the moment by a scalar
     * @param scalar
     * @return product
     */
    public Moment scalar(final double scalar) {
        Moment product;

        final double angularProduct = this.getAngular()* scalar;
        product = new Moment(this.getLinear().scalarProduct(scalar), angularProduct);

        return product;
    }

    @Override
    public String toString() {
        return "Moment [angular=" + angular + ", linear=" + linear + "]";
    }
}
