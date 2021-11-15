package com.example;

public class GameLoop {
    private static final boolean TRUE = true;
    public static void main(String[] args) {
        Ship myShip = new Ship(new Vector(0, 0),0,0);
        
        Module tank = new Module(new Vector(-2,0),2,1);
        Module cockpit = new Module(new Vector(0,0),0,0);
        Motor mainThruster = new Motor(new Vector(1,0),1,Math.PI,2);

        myShip.addChildren(tank);
        myShip.addChildren(cockpit);
        myShip.addChildren(mainThruster);

        Moment step = myShip.getImpulse();
        System.out.println(step); 
    }
}
