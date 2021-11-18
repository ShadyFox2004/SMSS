package com.example;
import java.util.ArrayList;
public class Transform {
    
    public Transform() {
        this(DEFAULT_POSITION, DEFAULT_ANGLE, DEFAULT_PARENT, DEFAULT_CHILDREN);
    }

    public Transform(Vector position, double angle, Transform parent, ArrayList<Transform> children) {
        this.position = position;
        this.angle = angle;
        this.parent = parent;
        this.children = children;
    }

    public static final Vector DEFAULT_POSITION = new Vector(0.0, 0.0);
    public static final Double DEFAULT_ANGLE = 0.0;
    public static final Transform DEFAULT_PARENT = null;
    public static final ArrayList<Transform> DEFAULT_CHILDREN = new ArrayList<Transform>(0);

    Vector position;
    Double angle;
    Transform parent;
    ArrayList<Transform> children;

    void setLocalPos(Vector localPosition) {
        this.position = localPosition;
    }

    //TODO: Implement setGlobalPosition(Vector position)

    //TODO: Implement setLocalRotation(double angle)

    //TODO: Implement setGlobalRotation(double angle)

    //TODO: Implement transformLocalToGlobalPoint(Vector point)

    //TODO: Implement transformLocalToGlobalVector(Vector vector)

    //TODO: Implement transformLocalToGlobalDirection(Vector direction)

    //TODO: Implement transformGlobalToLocalPoint(Vector point)

    //TODO: Implement transformGlobalToLocalVector(Vector vector)

    //TODO: Implement transformGlobalToLocalDirection(Vector direction)

    //TODO: Implement rotate(double angle)

    //TODO: Implement move(Vector displacement)

    //TODO: Implement getLocalPosition()

    //TODO: Implement getGlobalPosition

    //TODO: Implement getLocalRotation

    //TODO: Implement getGlobalRotation

    //TODO: Implement setParent(Transform parent)

    //TODO: Implement getParent

    //TODO: Implement getChildren

    //TODO: Implement addChildren(Transform parent)

    //TODO: Implement removeChildren(Transform parent)

    //TODO: Implement getChild(int index)
}
