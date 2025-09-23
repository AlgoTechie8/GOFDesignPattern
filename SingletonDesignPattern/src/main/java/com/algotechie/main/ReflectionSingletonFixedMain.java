package com.algotechie.main;

import java.lang.reflect.Constructor;

import com.algotechie.singleton.ReflectionSingleton;

// Fixed Test main
public class ReflectionSingletonFixedMain {

	public static void main(String[] args) throws Exception {
		
		// 01 Normal Check		
		ReflectionSingleton obj1 = ReflectionSingleton.getInstance();
		ReflectionSingleton obj2 = ReflectionSingleton.getInstance();
		System.out.println("Normal Check : "+(obj1 == obj2)); // true
		System.out.println("Object 1 hashcode : "+obj1.hashCode());
		System.out.println("Object 2 hashcode : "+obj2.hashCode());
		System.out.println();
		
		// Reflection API Test		
		// NoSuchMethodException
		Constructor<ReflectionSingleton> constructor = ReflectionSingleton.class.getDeclaredConstructor(); 

		constructor.setAccessible(true); // to access private constructor
		// IllegalAccessException, IllegalArgumentException, InvocationTargetException
		ReflectionSingleton obj3 = constructor.newInstance(); 
		System.out.println("Reflection Check : "+(obj1 == obj3)); // true
		System.out.println("Object 1 hashcode : "+obj1.hashCode());
		System.out.println("Object 3 hashcode : "+obj3.hashCode());
		System.out.println();
	}

}
