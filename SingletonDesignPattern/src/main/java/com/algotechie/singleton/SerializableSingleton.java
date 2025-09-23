package com.algotechie.singleton;

import java.io.Serializable;

//07. Serialization / Deserialization 
public class SerializableSingleton implements Serializable{
	// Declare same class-type member as private and static
	private static SerializableSingleton instance;
	
	// Declare Constructor as private
	private SerializableSingleton() {
		// No Operation
	}
	
	// Declare static method to create only one instance of same class
	public static SerializableSingleton getInstance() {
		if (instance == null) {
			instance = new SerializableSingleton();
		}
		return instance;
	}
	
	/*
	 * Protected method only accessable in same package or its subclasses.
	 * Note : That is reason I made it public for testing purpose
	 */
	public Object readResolve() {
		return instance; // getInstance()
	}
}
