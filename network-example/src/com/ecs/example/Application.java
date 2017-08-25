package com.ecs.example;

public class Application {

	public static void main(String[] args) {
		try {
			Network network = new Network(8);
			network.connect(1, 2);
			network.connect(6, 2);
			network.connect(2, 4);
			network.connect(5, 8);
			network.printNodes();
			
			System.out.println("QUERY RESULTS:");
			System.out.println("Querry 1 and 2 = " + network.query(1, 2));
			System.out.println("Querry 1 and 6 = " + network.query(1, 6));
			System.out.println("Querry 6 and 4 = " + network.query(6, 4));
			System.out.println("Querry 3 and 4 = " + network.query(3, 4));
			System.out.println("Querry 1 and 7 = " + network.query(1, 7));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
