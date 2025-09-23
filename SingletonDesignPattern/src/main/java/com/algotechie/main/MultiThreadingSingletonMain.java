package com.algotechie.main;

import com.algotechie.singleton.MultiThreadingSingleton;

//09. Multi-Threading
public class MultiThreadingSingletonMain {

	public static void main(String[] args) {
		
		MultiThreadingSingleton obj1 =  MultiThreadingSingleton.getInstance();
		System.out.println("Object 1 hashcode : "+obj1.hashCode());
		System.out.println();
		
		Runnable task = () -> {
			MultiThreadingSingleton obj2 = MultiThreadingSingleton.getInstance();
			System.out.println("Thread got instance: " + obj2.hashCode());
		};
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		// may print different hashCodes so resolve this issue using synchronized method or synchronized block double checking
		t1.start(); t2.start(); 
	}
}
