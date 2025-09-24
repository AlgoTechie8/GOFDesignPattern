package com.algotechie.custom.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.algotechie.mutable.StudentWithMutableList;

public class StudentWithMutableListMain {

	public static void main(String[] args) {
		List<String> subjects = new ArrayList<>(Arrays.asList("Math", "Science"));
		
		StudentWithMutableList student = new StudentWithMutableList(101, "Ram", subjects);
		
		System.out.println("Before Modify : "+student);
		
		// Try to modify original list
		subjects.add("Computer");
		System.out.println("After Modify : "+student); // unaffected
		
		// Try to modify via getter
		List<String> gotSubjects = student.getSubjects();
		gotSubjects.add("History"); // throws UnsupportedOperationException
		System.out.println("After Modify using getter : "+student);
	}

}
