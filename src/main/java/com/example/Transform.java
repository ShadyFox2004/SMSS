package com.example;
import java.util.ArrayList;
public class Transform {
    
    public Transform() {
        this(DEFAULT_POSITION, DEFAULT_ANGLE, DEFAULT_PARENT, DEFAULT_CHILDREN);
    }

    public Transform(Vector position, double angle, Transform parent, ArrayList<Transform> children) {
        setLocalPosition(position);
        setLocalRotation(angle);
        setChildren(children);
        setParent(parent);
    }

    public static final Vector DEFAULT_POSITION = Vector.ZERO;
    public static final Double DEFAULT_ANGLE = 0.0;
    public static final Transform DEFAULT_PARENT = null;
    public static final ArrayList<Transform> DEFAULT_CHILDREN = new ArrayList<Transform>(0);

    private Vector position = DEFAULT_POSITION;
    private Double angle = DEFAULT_ANGLE;
    private Transform parent = DEFAULT_PARENT;
    private ArrayList<Transform> children = DEFAULT_CHILDREN;

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
        Vector globalPosition;
        if (parent == null)
            globalPosition = this.position;
        else
            globalPosition = parent.getGlobalPosition().add(this.position.rotate(parent.getGlobalRotation()));

        return globalPosition;
    }

    public Double getLocalRotation() {
        return this.angle;
    }

    public Double getGlobalRotation() {
        return (parent == null ? 0.0 : parent.getGlobalRotation()) + this.angle;
    }

    public void setParent(Transform parent) {
        if (!(parent == null)) {
            parent.addChild(this);
        }
        this.parent = parent;
    }

    public Transform getParent() {
        return this.parent;
    }

    public void setChild(int index, Transform child) {
        if (child == null) {
            System.err.println("Could not set child at Index: " + index + ", because it was null");
        } else {
            child.parent = this;
            children.set(index, child);
        }
    }

    public void setChildren(ArrayList<Transform> children) {
       this.children = children;
    }

    public ArrayList<Transform> getChildren() {
        return children;
    }

    public void addChild(Transform child) {
        if (child == null) {
            System.err.println("Could not add child because it was null");
        } else {
            child.parent = this;
            this.children.add(child);
        }
    }

    public void removeChildren(Transform child) {
        child.parent = null;
        this.children.remove(child);
    }

    public Transform getChild(int index) {
        return children.get(index);
    }
}
