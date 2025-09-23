package com.algotechie.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.algotechie.singleton.NonFixedSingleton;

public class SingletonBreakerMain {

	public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, ClassNotFoundException {

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
		
		// 03 Break using Cloning
		NonFixedSingleton obj4 = (NonFixedSingleton) obj1.clone();
		System.out.println("Cloning Check : "+(obj1 == obj4)); // false (broken)
		System.out.println("Object 4 hashcode : "+obj4.hashCode());
		System.out.println();
		
		// 04 break using Serialization / Deserialization
		
		// When you serialize and then deserialize a Singleton, a new instance gets created.
		ObjectOutput os = new ObjectOutputStream(new FileOutputStream("serialization.ser"));
		os.writeObject(obj1); // IOException
		os.close();
		
		ObjectInput is = new ObjectInputStream(new FileInputStream("serialization.ser"));
		NonFixedSingleton obj5 = (NonFixedSingleton) is.readObject(); //IOException, ClassNotFoundException
		is.close();
		System.out.println("Serialization Check : "+(obj1 == obj5));// false (Broken)
		System.out.println("Object 5 hashcode : "+obj5.hashCode());
		System.out.println();
		
		// 05 break Using Multi-threading issue (run threads that call getInstance())
		 System.out.println("Multi-Threading : ");		
		Runnable task = () -> {
			NonFixedSingleton obj6 = NonFixedSingleton.getInstance();
			 System.out.println("Thread got instance: " + obj6.hashCode());
		};
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		t1.start(); t2.start(); // may print different hashCodes
	}
}
