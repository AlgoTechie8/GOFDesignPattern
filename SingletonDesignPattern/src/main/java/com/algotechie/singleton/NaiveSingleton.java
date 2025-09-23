package com.algotechie.singleton;

import java.io.Serializable;

// Naive Singleton (Vulnerable)
public class NaiveSingleton implements Serializable, Cloneable{
	private static NaiveSingleton instance;
	
	private NaiveSingleton() {
		// vulnerable, no check
	}
	
	public static NaiveSingleton getInstance() {
		if(instance == null) {
			instance = new NaiveSingleton();
		}
		return instance;
	}
	
	// protected Object clone()  -- Accesiblity to different package so change to public
	// but While implementing we should keep protected only
	// protected will access in same package
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone(); // vulnerable
	}
}
