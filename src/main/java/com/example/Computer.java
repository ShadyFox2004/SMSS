package com.example;

import java.util.Scanner;

public class Computer extends Module {
	public Computer(String id, Vector position, double mass, double direction) {
		super(id, position, mass, direction);
	}

	public boolean invokeTerminal(Ship parent) {
		System.out.print("Enter command : ");
		Scanner sc = new Scanner(System.in);
		String command = sc.next();

		if (command.equals("module")) {
			command = sc.next();
			Module module = parent.getToModuleById(command);
			if (module != null) {
				System.out.println(module.eval(sc));
			}
		}

		return true;
	}
}
