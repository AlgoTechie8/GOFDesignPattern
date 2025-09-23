package com.algotechie.singleton;

import java.io.Serializable;

// If the Singleton class implements Cloneable, the clone() method can create a new object.
public class NonFixedSingleton implements Cloneable, Serializable{
	// Declare a private and static member of same class-type in the class
	private static NonFixedSingleton instance;
	
	// Declare a Constructor is private
	private NonFixedSingleton() {
		// No Operation
	}
	
	// Declare static method to create only one instance of same class
	public static NonFixedSingleton getInstance() {
		if(instance == null) {
			instance = new NonFixedSingleton();  // multiple threads may create multiple instances
		}
		return instance;
	}
	
	// Override clone and make it public
    @Override
    public NonFixedSingleton clone() {
        try {
            return (NonFixedSingleton) super.clone(); // call Object.clone() // // vulnerable
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // should never happen
        }
    }
    
    // When you serialize and then deserialize a Singleton, a new instance gets created.

}
