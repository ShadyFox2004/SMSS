package com.example;

public class GameLoop {
    private static final boolean TRUE = true;
    public static void main(String[] args) {
        Ship myShip = new Ship("EAGLE", new Vector(),0,Math.PI/2);

        Computer computer = new Computer("Cmptr", new Vector(0, 0),0,0);
        Module cockpit = new Module("Cp", new Vector(0,0),0,0);
        Motor mainThruster = new Motor("ml", new Vector(0,1),1,0);
        Motor secondVector = new Motor("mr", new Vector(0,-1),1,0);

        myShip.addChildren(computer);
	    myShip.addChildren(cockpit);
        myShip.addChildren(mainThruster);
        myShip.addChildren(secondVector);

        boolean gameOn = true;
        while (gameOn) {
            gameOn = computer.invokeTerminal(myShip);
        }
    }
}
