package com.example;

public class GameLoop {
    private static final boolean TRUE = true;
    public static void main(String[] args) {
        Ship myShip = new Ship(new Vector(0, 0),0,Math.PI/2);

        Module cockpit = new Module(new Vector(0,0),0,0);
        Motor mainThruster = new Motor(new Vector(0,1),1,0,1);
        //Motor secondThruster = new Motor(new Vector(0,-2),4,-Math.PI/2,1);

        myShip.addChildren(cockpit);
        myShip.addChildren(mainThruster);
        //myShip.addChildren(secondThruster);

        Moment step = myShip.getImpulse();
        System.out.println(step); 
    }
}
