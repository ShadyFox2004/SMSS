package com.example;

public class Ship extends Module {
    private Module[] children;

    // TODO Make constructors

    public Module[] getChildren() {
        return children;
    }

    // TODO Make the table setting logic
    // TODO Make the center off mass at the origin

    public void setChildren(Module[] children) {
        this.children = children;
    }
}
