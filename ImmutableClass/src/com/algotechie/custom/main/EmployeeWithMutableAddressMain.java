package com.algotechie.custom.main;

import com.algotechie.mutable.Address;
import com.algotechie.mutable.EmployeeWithMutableAddress;

public class EmployeeWithMutableAddressMain {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Address address = new Address();
		address.setFlatNo("AA101");
		address.setStreet("Teacher colony");
		address.setCity("Mumbai");
		
		EmployeeWithMutableAddress employee = new EmployeeWithMutableAddress(101, "Ram", address);
		System.out.println("Original Employee : "+employee);
		System.out.println("Before Modifying : "+employee.getAddress().getCity());
		
		// Try modifying original address
		// Below line problem solveed to write cloning logic inside constructor body
		address.setCity("Banglore");  //still Mumbai
		
		// Line no 24 (employee.getAddress().getCity()) problem will solved to write 
		// cloning in getter method of Mutable class inside immutable class 
		// employee.getAddress().getCity() - 
		System.out.println("After Modfying : "+employee.getAddress().getCity());
		
        // Try modifying via getter
        employee.getAddress().setCity("Delhi");
        System.out.println(employee); // still Mumbai		
	}
}
