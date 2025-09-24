package com.algotechie.simple;

// Step 1: Declare class as final
public final class Employee {
	// Step 2: Declare all data members are private and final
	private final int id;
	private final String name;
	
	// Step 3: Declare parameterized constructor to initialize final variables
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;		
	}
	// Step 4: Provide only getter method means only access value, wont modify
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}	
}
