package com.algotechie.singleton;

//02. Static Block Initialization 
public class StaticBlockInitializationSingletonClass {
	// Delcare a static member of the same class type in the class
	private static StaticBlockInitializationSingletonClass instance;
		
	// static bloc excute only once when the class has loaded...
	static {
		instance = new StaticBlockInitializationSingletonClass();
	}
	
	// Constructor is declared as private
	private StaticBlockInitializationSingletonClass() {
		// No Operation
	}
	
	// Declare a static method to create only one instance (static factory method)
	public static StaticBlockInitializationSingletonClass getInstance() {
		return instance;
	}

}
