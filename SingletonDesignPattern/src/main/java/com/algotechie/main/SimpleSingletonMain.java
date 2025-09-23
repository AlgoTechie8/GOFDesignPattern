package com.algotechie.main;

import com.algotechie.singleton.EagerInitializationSingleton;
import com.algotechie.singleton.EnumSingleton;
import com.algotechie.singleton.InnerStaticHelperSingleton;
import com.algotechie.singleton.LazyInitializationSingleton;
import com.algotechie.singleton.StaticBlockInitializationSingletonClass;

public class SimpleSingletonMain {

	// But here is problem with Multi-Threading, Cloning, Serialization, and Reflaction will break the simple approach
	// To Solve Above proble we have to gave solution
	
	public static void main(String[] args) {
		System.out.println("01. Eager Initialization :");
		//01. Eager Initialization
		EagerInitializationSingleton eobj1 = EagerInitializationSingleton.getInstance();
		EagerInitializationSingleton eobj2 = EagerInitializationSingleton.getInstance();
		
		System.out.println("Eager Object 1 hashcode : "+eobj1.hashCode());
		System.out.println("Eager Object 2 hashcode : "+eobj2.hashCode());
		System.out.println("eobj1 == eobj2 : "+(eobj1 == eobj1));
		
		System.out.println();
		
		System.out.println("02. Lazy Initialization : ");
		//02. Lazy Initialization
		LazyInitializationSingleton lobj1 = LazyInitializationSingleton.getInstance();
		LazyInitializationSingleton lobj2 = LazyInitializationSingleton.getInstance();
		
		System.out.println("Lazy Object 1 hashcode : "+lobj1.hashCode());
		System.out.println("Lazy Object 2 hashcode : "+lobj2.hashCode());
		System.out.println("lobj1 == lobj2 : "+(lobj1 == lobj1));
		
		System.out.println();
		
		System.out.println("03. Static block Initialization : ");
		//03. Static Block Initialization
		StaticBlockInitializationSingletonClass sobj1 = StaticBlockInitializationSingletonClass.getInstance();
		StaticBlockInitializationSingletonClass sobj2 = StaticBlockInitializationSingletonClass.getInstance();
		
		System.out.println("Static Object 1 hashcode : "+sobj1.hashCode());
		System.out.println("Static Object 2 hashcode : "+sobj2.hashCode());
		System.out.println("sobj1 == sobj2 : "+(sobj1 == sobj1));

		System.out.println();
		
		System.out.println("04. Using Enum : ");
		// 04. Using Enum
		EnumSingleton enum1 = EnumSingleton.INSTANCE;
		EnumSingleton enum2 = EnumSingleton.INSTANCE;
		
	
		
		System.out.println("Enum 1 hashcode : "+enum1.hashCode());
		System.out.println("Enum 2 hashcode : "+enum2.hashCode());
		System.out.println("enum1 == enum2 : "+(enum1 == enum2));
		
		System.out.println();
		
		System.out.println("05. Inner Static Helper : ");
		// 05. Inner Static Helper
		InnerStaticHelperSingleton isobj1 = InnerStaticHelperSingleton.getInstance();
		InnerStaticHelperSingleton isobj2 = InnerStaticHelperSingleton.getInstance();
		
		System.out.println("Inner class Object 1 hashcode : "+isobj1.hashCode());
		System.out.println("Inner class Object 2 hashcode : "+isobj2.hashCode());
		System.out.println("isobj1 == isobj2 : "+(isobj1 == isobj2));
	}

}
