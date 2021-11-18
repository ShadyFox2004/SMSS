package com.example;
import java.util.ArrayList;
public class Transform {
    
    public Transform() {
        this(DEFAULT_POSITION, DEFAULT_ANGLE, DEFAULT_PARENT, DEFAULT_CHILDREN);
    }

    public Transform(Vector position, double angle, Transform parent, ArrayList<Transform> children) {
        setLocalPosition(position);
        setLocalRotation(angle);
        setParent(parent);
        setChildren(children);
    }

    public static final Vector DEFAULT_POSITION = new Vector(0.0, 0.0);
    public static final Double DEFAULT_ANGLE = 0.0;
    public static final Transform DEFAULT_PARENT = null;
    public static final ArrayList<Transform> DEFAULT_CHILDREN = new ArrayList<Transform>(0);

    private Vector position;
    private Double angle;
    private Transform parent;
    private ArrayList<Transform> children;

    public void setLocalPosition(Vector localPosition) {
        this.position = localPosition;
    }

    public void setGlobalPosition(Vector globalPosition) {
        this.position = globalPosition.sub(parent.getGlobalPosition());
    }

    public void setLocalRotation(double localAngle) {
        this.angle = localAngle;
    }

    public void setGlobalRotation(double globalAngle) {
        this.angle = globalAngle - parent.getGlobalRotation();
    }

    //TODO: Implement transformLocalToGlobalPoint(Vector point)

    //TODO: Implement transformLocalToGlobalVector(Vector vector)

    //TODO: Implement transformLocalToGlobalDirection(Vector direction)

    //TODO: Implement transformGlobalToLocalPoint(Vector point)

    //TODO: Implement transformGlobalToLocalVector(Vector vector)

    //TODO: Implement transformGlobalToLocalDirection(Vector direction)

    public void rotate(double angle) {
        this.angle += angle;
    }

    public void move(Vector displacement) {
        this.position = this.position.add(displacement);
    }

    public Vector getLocalPosition() {
        return this.position;
    }

    public Vector getGlobalPosition() {
        return (parent == null ? Vector.ZERO : parent.getGlobalPosition().rotate(-parent.angle)).add(this.position);
    }

    public Double getLocalRotation() {
        return this.angle;
    }

    public Double getGlobalRotation() {
        return (parent == null ? 0.0 : parent.getGlobalRotation()) + this.angle;
    }

    public void setParent(Transform parent) {
        this.parent = parent;
    }

    public Transform getParent() {
        return this.parent;
    }

    public void setChildren(ArrayList<Transform> children) {
       this.children = children;
    }

    public ArrayList<Transform> getChildren() {
        return children;
    }

    public void addChild(Transform child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void removeChildren(Transform child) {
        child.setParent(null);
        this.children.remove(child);
    }

    public Transform getChild(int index) {
        return children.get(index);
    }
}
