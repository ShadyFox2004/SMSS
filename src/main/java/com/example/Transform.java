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

    
}
