package com.algotechie.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import com.algotechie.singleton.FixedSerializableSingleton;

//07. Serialization / Deserialization 
public class FixedSerializableSingletonMain {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// Normal Check		
		FixedSerializableSingleton obj1 = FixedSerializableSingleton.getInstance();
		
		// Serialization process
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("serialization1.ser"));
		out.writeObject(obj1);
		out.close(); // IOException
		
		// Deserialization
		ObjectInput in = new ObjectInputStream(new FileInputStream("serialization1.ser"));
		FixedSerializableSingleton obj2 = (FixedSerializableSingleton) in.readObject();
		in.close();	// ClassNotFoundException, IOException
		System.out.println("Serialization Check : "+(obj1 == obj2)); // true
		System.out.println("Object 1 hashcode : "+obj1.hashCode());
		System.out.println("Object 2 hashcode : "+obj2.hashCode());
		System.out.println();
		
	}

}
