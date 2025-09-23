package com.algotechie.singleton;

//04. Enum Singleton (best) - Unbreakable
/* 
 * Cannot be broken by reflection, serialization, cloning, or thread issues.
 * Handles class loading automatically.
*/
public enum EnumSingleton {
	INSTANCE;
	
	public void doSomething() {
		System.out.println("Singleton using Enum");
	}
}
