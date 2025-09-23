package com.algotechie.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.algotechie.singleton.AllFixedSingleton;
import com.algotechie.singleton.SerializableSingleton;

public class AllFixedSingletonMain {

	public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FileNotFoundException, IOException, ClassNotFoundException, CloneNotSupportedException {
		AllFixedSingleton obj1 = AllFixedSingleton.getInstance();
		
		// 01 Serialization
		// FileNotFoundException, IOException
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("fixed.ser"));
		out.writeObject(obj1);
		out.close(); // IOException
		
		// Deserialization
		ObjectInput in = new ObjectInputStream(new FileInputStream("fixed.ser"));
		AllFixedSingleton obj2 = (AllFixedSingleton) in.readObject();
		in.close();	// ClassNotFoundException, IOException
		System.out.println("02 Serialization : ");
		System.out.println("Object 2 Hashcode : "+obj2.hashCode());
		System.out.println();
		
		// 02. Multi-threading
		Runnable task = () -> {
			AllFixedSingleton obj3 = AllFixedSingleton.getInstance();
			System.out.println("Thread got instance: " + obj3.hashCode());
		};
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		// may print different hashCodes to resolve this issue using synchronized method or synchronized block double checking
		t1.start(); t2.start();
		System.out.println();
		
		// 03. Cloning
		AllFixedSingleton obj4 = (AllFixedSingleton) obj1.clone(); // CloneNotSupportedException
		System.out.println("04 Cloning : ");
		System.out.println("Object 4 Hashcode : "+obj4.hashCode());
		System.out.println();
		
		// 03. Reflaction
		Constructor<AllFixedSingleton> constructor = AllFixedSingleton.class.getDeclaredConstructor(); //NoSuchMethodException
		constructor.setAccessible(true);
		// InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
		AllFixedSingleton obj5 = constructor.newInstance();  // throw Exception
		System.out.println("01. Reflaction : ");
		System.out.println("Object 5 Hashcode : "+obj5.hashCode());
		System.out.println();		
	}

}
