package com.algotechie.singleton;

// 06. Reflection 
public class ReflectionSingleton {
	// Declare a private and static member of same class-type in the class
	private static ReflectionSingleton instance;
	
	// Delcare Constructor as private with condition
	private ReflectionSingleton() {
		if (instance != null) {
			throw new RuntimeException("Use getInstance() method to create Instance of Singleton class");
		}
	}
	// Declare static method to create only one instance of same class
	public static ReflectionSingleton getInstance() {
		if(instance == null) {
			instance = new ReflectionSingleton();
		}
		return instance;
	}	

}
