package com.algotechie.main;

import com.algotechie.singleton.CloneableSingleton;

//08. Cloning
public class CloneableSingletonFixedMain {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		// Fixed cloning 
		CloneableSingleton obj1 = CloneableSingleton.getInstance();
		CloneableSingleton obj2 = (CloneableSingleton) obj1.clone(); // Through exception said CloneNotSupportedException
		System.out.println("Cloning Check : "+(obj1 == obj2)); 
	}
	
	
}
