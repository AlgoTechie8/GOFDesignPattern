package com.algotechie.singleton;

import java.io.Serializable;

//07. Serialization / Deserialization 
public class FixedSerializableSingleton implements Serializable{
	// Declare same class-type member as private and static
	private static FixedSerializableSingleton instance;
	
	// Declare Constructor as private
	private FixedSerializableSingleton() {
		// No Operation
	}
	
	// Declare static method to create only one instance of same class
	public static FixedSerializableSingleton getInstance() {
		if (instance == null) {
			instance = new FixedSerializableSingleton();
		}
		return instance;
	}
	
	/*
	 * Protected method only accessable in same package or its subclasses.
	 * Note : That is reason I made it public for testing purpose
	 */
	protected Object readResolve() {
		return instance; // getInstance()
	}
}
