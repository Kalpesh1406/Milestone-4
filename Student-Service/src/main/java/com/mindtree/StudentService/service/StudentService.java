package com.mindtree.StudentService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.StudentService.entity.Student;
import com.mindtree.StudentService.model.ResponseTemplate;

@Service
public interface StudentService {
	
	Student addStudent(Student student);
	List<Student> listOfStudents();
	Student findStudentByRollNo(long rollNo);
	ResponseTemplate studentWithCollege(long rollNo);
	Student assignToCollege(long rollNo, long collegeId);
	List<Student> getStudentsByCollegeId(long collegeId);
	List<Student> getStudentsByCollegeWithDescAge(long collegeId);
	List<Student> getStudentByStream(String stream);
	
}
