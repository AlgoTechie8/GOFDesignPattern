package com.algotechie.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

import com.algotechie.singleton.NaiveSingleton;

public class NaiveSingletonMain {

	public static void main(String[] args) throws Exception {
		// Normal instance
		NaiveSingleton obj1 = NaiveSingleton.getInstance();
		NaiveSingleton obj2 = NaiveSingleton.getInstance();
		System.out.println("Normal Check : "+(obj1 == obj2)); // true
		System.out.println("Object 1 Hashcode : "+obj1.hashCode());
		System.out.println("Object 2 Hashcode : "+obj2.hashCode());
		System.out.println();
		// 01. Reflection
		Constructor<NaiveSingleton> constructor = NaiveSingleton.class
							.getDeclaredConstructor(); // NoSuchMethodException 
		constructor.setAccessible(true);
		// IllegalAccessException, IllegalArgumentException, 
		// InvocationTargetException, InstantiationException
		NaiveSingleton obj3 = constructor.newInstance();
		System.out.println("Reflection : "+(obj1 == obj3)); // false
		System.out.println("Object 3 Hashcode : "+obj3.hashCode());
		System.out.println();
		
		// 02. cloning
		NaiveSingleton obj4 = (NaiveSingleton) obj1.clone(); // CloneNotSupportedException
		System.out.println("Cloning : "+(obj1 == obj4)); // false
		System.out.println("Object 4 Hashcode : "+obj4.hashCode());
		System.out.println();
		
		// 03. Serialization / Deserialization
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("NaiveSingleton.ser"));
		oos.writeObject(obj1);
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("NaiveSingleton.ser"));
		NaiveSingleton obj5 = (NaiveSingleton) ois.readObject();
		ois.close();
		System.out.println("Serialization : "+(obj1 == obj5)); // false
		System.out.println("Object 5 Hashcode : "+obj5.hashCode());
		System.out.println();
		
		// 04. Multiple Class Loaders (simulate by custom class loader in complex apps)
		 System.out.println("Multiple Class Loaders can break too (demo skipped)");
		 System.out.println();
		 
		
		// 05. Multi-threading issue (run threads that call getInstance())
		 System.out.println("Multi-Threading : ");
		 Runnable task = () -> {
			 NaiveSingleton obj6 = NaiveSingleton.getInstance();
			 System.out.println("Thread got instance: " + obj6.hashCode());
		 };
		 Thread t1 = new Thread(task);
		 Thread t2 = new Thread(task);
		 t1.start(); t2.start();  // may print different hashCodes
	}

}
