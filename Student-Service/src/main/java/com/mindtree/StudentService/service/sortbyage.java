package com.mindtree.StudentService.service;

import java.util.Comparator;

import com.mindtree.StudentService.entity.Student;

public class sortbyage implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o2.getAge()- o1.getAge();
	}

}
