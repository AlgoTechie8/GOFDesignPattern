package com.algotechie.singleton;

import java.io.Serializable;

// Combine all fixes of Singleton DP
public class AllFixedSingleton implements Serializable, Cloneable{
	private static final long serialVersionUID = 1L;
	// Declare same class-type member as private, static and volatile
	private static volatile AllFixedSingleton instance;
	
	// With lazy initialization, your constructor check (if (instance != null)) does not work if 
	// reflection is called before getInstance(), because instance is still null.
	
	//private static boolean instanceCreated = false;
	
	// Declare Constructor as private
	private AllFixedSingleton() {
		if (instance != null) {
			throw new RuntimeException("use getInstance() method to create object of same class.");
		}
	}
	
	// Declare synchronized, static factory method to create instance of same class only once
	// Double-Checked Locking (lazy + thread-safe)
	public static AllFixedSingleton getInstance() {
		if (instance == null) {
			synchronized (AllFixedSingleton.class) {
				if (instance == null) {
					instance = new AllFixedSingleton();
				}
			}
		}
		return instance;
	}
	// Serialization / Deserialization
	protected Object readResolve() {
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
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
