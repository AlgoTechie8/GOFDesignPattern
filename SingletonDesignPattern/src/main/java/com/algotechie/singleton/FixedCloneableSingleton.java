package com.algotechie.singleton;

//08. Cloning
public class FixedCloneableSingleton implements Cloneable{
	// Declare same class-type member as a private and static
	private static FixedCloneableSingleton instance;
	
	// Declare Constructor as private, so no one can create object outside the class 
	private FixedCloneableSingleton() {
		// No Operation
	}
	
	// Declare a static factory method to create same class-type object and return it
	public static FixedCloneableSingleton getInstance() {
		if(instance == null) {
			instance = new FixedCloneableSingleton();
		}
		return instance;
	}
	/*
	 * Override the clone() method of Object class, So If someone is trying to
	 * create object using clone() then this method will through
	 * CloneNotSupporetedException exception or directly return same instance
	 * clone() method of object class is protected. If you override clone() method
	 * then protected method only accessable in same package or its subclasses.
	 * Note : That is reason I made it public for testing purpose
	 */
	 public Object clone() throws CloneNotSupportedException {
		 throw new CloneNotSupportedException();
		 // OR
		 //return instance;
	 }
}
