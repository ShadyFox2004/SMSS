package com.example;

import java.util.Scanner;

public class Computer extends Module {
	public Computer(String id, Vector position, double mass, double direction) {
		super(id, position, mass, direction);
	}

	public boolean invokeTerminal(Ship parent) {
		// I know, this is huge, but its the only way to make a command line
		System.out.print("Enter command : ");
		Scanner sc = new Scanner(System.in);
		String command = sc.next();

		if (command.equals("module")) {
			command = sc.next();
			Module module = parent.getToModuleById(command);
			if (module != null) {
				System.out.println(module.eval(sc));
			} else {
				System.out.println("Module id not found");
				return true;
			}
		} else if (command.equals("exit")) {
			System.out.println("Exiting the space ship");
			return false;
		} else if (command.equals("simulate")) {
			command = sc.next();
			if (command.equals("impulse")) {
				Moment moment = parent.getImpulse();
				System.out.println(moment);
			}
		} else if (command.equals("run")) {
			command = sc.next();
			double seconds = Double.parseDouble(command);
			parent.computePhysics(seconds);
			System.out.println("Running time for : " + seconds + " sec");	
		}
		return true;
	}
}
