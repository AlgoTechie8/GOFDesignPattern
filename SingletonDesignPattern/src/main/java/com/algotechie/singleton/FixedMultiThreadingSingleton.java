package com.algotechie.singleton;

//09. Multi-Threading
public class FixedMultiThreadingSingleton {
	// Declare same class-type member as private, static
	private static FixedMultiThreadingSingleton instance;
	
	// Declare Constructor as private
	private FixedMultiThreadingSingleton() {
		// No Operation
	}
	
	// Declare synchronized, static factory method to create instance of same class only once
	// Double-Checked Locking (lazy + thread-safe)
	public  static FixedMultiThreadingSingleton getInstance() {
		if (instance == null) {
			synchronized (FixedMultiThreadingSingleton.class) {
				if (instance == null) {
					instance = new FixedMultiThreadingSingleton();
				}
			}
		}
		return instance;
	}

}
