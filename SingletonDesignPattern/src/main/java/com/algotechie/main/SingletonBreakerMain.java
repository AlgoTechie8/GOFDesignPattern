package com.algotechie.main;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.algotechie.singleton.NonFixedSingleton;

public class SingletonBreakerMain {

	public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		// 01 Normal Check		
		NonFixedSingleton obj1 = NonFixedSingleton.getInstance();
		NonFixedSingleton obj2 = NonFixedSingleton.getInstance();
		System.out.println("Normal Check : "+(obj1 == obj2)); // true
		System.out.println("Object 1 hashcode : "+obj1.hashCode());
		System.out.println("Object 2 hashcode : "+obj2.hashCode());
		System.out.println();
		
		// 02 Break using Reflection 
		Constructor<NonFixedSingleton> constructor = NonFixedSingleton.class.getDeclaredConstructor(); // NoSuchMethodException 
		constructor.setAccessible(true);
		// InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
		NonFixedSingleton obj3 = constructor.newInstance();
		System.out.println("Reflection Check : "+(obj1 == obj3)); // false (broken)
		System.out.println("Object 3 hashcode : "+obj3.hashCode());
		System.out.println();
		
	}

}
