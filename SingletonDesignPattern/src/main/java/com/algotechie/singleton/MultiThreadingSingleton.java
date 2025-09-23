package com.algotechie.singleton;

//09. Multi-Threading
public class MultiThreadingSingleton {
	// Declare same class-type member as private, static
	private static MultiThreadingSingleton instance;
	
	// Declare Constructor as private
	private MultiThreadingSingleton() {
		// No Operation
	}
	
	// Declare synchronized, static factory method to create instance of same class only once
	// Double-Checked Locking (lazy + thread-safe)
	public  static MultiThreadingSingleton getInstance() {
		if (instance == null) {
			synchronized (MultiThreadingSingleton.class) {
				if (instance == null) {
					instance = new MultiThreadingSingleton();
				}
			}
		}
		return instance;
	}

}
