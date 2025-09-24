package com.algotechie.mutable;

// 01. Declare class as final
final public class EmployeeWithMutableAddress {
	
	// 02 Declare datamember as private and final 	
	private final int id;
	private final String name;
	private final Address address;
	
	// 03 Declare parameterized constructor and initialize data member
	public EmployeeWithMutableAddress(int id, String name, Address address) throws CloneNotSupportedException {
		super();
		this.id = id;
		this.name = name;
		
		// 05 Create deep copy of mutable object
		
		// Option 1: If Address implements Cloneable correctly
		this.address = (Address) address.clone(); 
		
		// OR
		
		// Option 2: Manual deep copy (safer)
		/*
		 * Address cloneAddress = new Address();
		 * cloneAddress.setFlatNo(address.getFlatNo());
		 * cloneAddress.setStreet(address.getStreet());
		 * cloneAddress.setCity(address.getCity());
		 * 
		 * this.address = cloneAddress;
		 */
		
		
	}

	// 04 Declare getters only	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() throws CloneNotSupportedException {
		// 05 Create deep copy of mutable object
			
		// Option 1: If Address implements Cloneable correctly
		return (Address) address.clone();
		
		// OR
		
		// Option 2: Manual deep copy (safer)
		/*
		 * Address clonedAddress = new Address();
		 * clonedAddress.setFlatNo(address.getFlatNo());
		 * clonedAddress.setStreet(address.getStreet());
		 * clonedAddress.setCity(address.getCity());
		 * 
		 * return clonedAddress;
		 */
	}

	@Override
	public String toString() {
		return "EmployeeWithMutableAddress [id=" + id + ", name=" + name + ", address=" + address + "]";
	}	
}
