package com.algotechie.mutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 01 Declare class as final
public final class StudentWithMutableList {
	// 02 Declare data member as private and final
	private final int rollNo;
	private final String name;
	private final List<String> subjects; // mutable list
	
	public StudentWithMutableList(int rollNo, String name, List<String> subjects) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		
		// Defensive copy of input list
		this.subjects = new ArrayList<>(subjects);		
	}

	public int getRollNo() {
		return rollNo;
	}

	public String getName() {
		return name;
	}

	public List<String> getSubjects() {
		// Option 1: Return unmodifiable list (safer, more efficient)
		// return Collections.unmodifiableList(subjects);
		
		// Option 2 (alternative): Return defensive copy
		return new ArrayList<>(subjects);
	}

	@Override
	public String toString() {
		return "StudentWithMutableList [rollNo=" + rollNo + ", name=" + name + ", subjects=" + subjects + "]";
	}
}
