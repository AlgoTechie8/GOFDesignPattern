package com.algotechie.singleton;

public class NonFixedSingleton {
	// Declare a private and static member of same class-type in the class
	private static NonFixedSingleton instance;
	
	// Declare a Constructor is private
	private NonFixedSingleton() {
		// No Operation
	}
	
	// Declare static method to create only one instance of same class
	public static NonFixedSingleton getInstance() {
		if(instance == null) {
			instance = new NonFixedSingleton();
		}
		return instance;
	}
	

}
