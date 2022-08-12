package com.mindtree.CollegeService.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String clgName;
	private int noOfStudent;
	
	public College() {
		super();
	}

	public College(long id, String clgName, int noOfStudent) {
		super();
		this.id = id;
		this.clgName = clgName;
		this.noOfStudent = noOfStudent;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClgName() {
		return clgName;
	}

	public void setClgName(String clgName) {
		this.clgName = clgName;
	}

	public int getNoOfStudent() {
		return noOfStudent;
	}

	public void setNoOfStudent(int noOfStudent) {
		this.noOfStudent = noOfStudent;
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", clgName=" + clgName + ", noOfStudent=" + noOfStudent + "]";
	}
}
