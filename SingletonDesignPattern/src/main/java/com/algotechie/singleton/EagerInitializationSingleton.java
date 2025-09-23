package com.algotechie.singleton;

//  01 :-  Eager Initialization
public class EagerInitializationSingleton {
	// Declare a private and static member of the same class type in the class 
	private static EagerInitializationSingleton instance = new EagerInitializationSingleton();
	
	// Declare Constructor as private
	private EagerInitializationSingleton() {
		// No operation
	}
	
	// Declare a static method to create only one instance 	
    // (satic factory method)
	public static EagerInitializationSingleton getInstance() {
		return instance;
	}
	

}
