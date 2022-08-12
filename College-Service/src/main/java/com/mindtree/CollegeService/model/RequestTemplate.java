package com.mindtree.CollegeService.model;

import java.util.ArrayList;
import java.util.List;

import com.mindtree.CollegeService.entity.College;

public class RequestTemplate {
	
	private College college;
	private List<Student> studentsList = new ArrayList<Student>();
	public RequestTemplate() {
		super();
	}
	public RequestTemplate(College college, List<Student> studentsList) {
		super();
		this.college = college;
		this.studentsList = studentsList;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public List<Student> getStudentsList() {
		return studentsList;
	}
	public void setStudentsList(List<Student> studentsList) {
		this.studentsList = studentsList;
	}
	
	

}
