package com.algotechie.main;

import com.algotechie.singleton.FixedCloneableSingleton;

//08. Cloning
public class FixedCloneableSingletonMain {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		// Fixed cloning 
		FixedCloneableSingleton obj1 = FixedCloneableSingleton.getInstance();
		FixedCloneableSingleton obj2 = (FixedCloneableSingleton) obj1.clone(); // Through exception said CloneNotSupportedException
		System.out.println("Cloning Check : "+(obj1 == obj2)); 
	}
	
	
}
