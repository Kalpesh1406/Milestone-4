package com.mindtree.CollegeService.model;

public class Student {
	
	
	private long rollNo;
	private String name;
	private String gender;
	private int age;
	private String stream;
	private long collegeId;
	
	public Student() {
		super();
	}

	
	public Student(long rollNo, String name, String gender, int age, String stream, long collegeId) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.stream = stream;
		this.collegeId = collegeId;
	}


	public long getRollNo() {
		return rollNo;
	}

	public void setRollNo(long rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}


	public long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}


	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", gender=" + gender + ", age=" + age + ", stream="
				+ stream + ", collegeId=" + collegeId + "]";
	}

}
