package com.example;

public class GameLoop {
    private static final boolean TRUE = true;
    public static void main(String[] args) {
        Ship myShip = new Ship("EAGLE", new Vector(0, 0),0,Math.PI/2);

        Computer computer = new Computer("Computer", new Vector(0, 0),0,0);
        Module cockpit = new Module("Cockpit", new Vector(0,0),0,0);
        Motor mainThruster = new Motor("mainThruster", new Vector(0,1),1,0);

        myShip.addChildren(computer);
	    myShip.addChildren(cockpit);
        myShip.addChildren(mainThruster);

        boolean gameOn = true;
        while (gameOn) {
            //Moment step = myShip.getImpulse();
            //System.out.println(step);
            gameOn = computer.invokeTerminal(myShip);
        }
    }
}
