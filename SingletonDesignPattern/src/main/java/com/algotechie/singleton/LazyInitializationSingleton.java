package com.algotechie.singleton;


// 03. Lazy Initialization 
public class LazyInitializationSingleton {
	// Declare a private and static member of the same class type in the class
	private static LazyInitializationSingleton instance;
	
	// Delcare a Constructor as private
	private LazyInitializationSingleton() {
		// No Operation
	}
	// Declare a static method to create only one instance
	public static LazyInitializationSingleton getInstance() {
		if(instance == null) {
			instance = new LazyInitializationSingleton();
		}
		return instance;
	}

}
