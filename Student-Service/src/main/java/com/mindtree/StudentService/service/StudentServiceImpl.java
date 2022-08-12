package com.mindtree.StudentService.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mindtree.StudentService.entity.Student;
import com.mindtree.StudentService.model.College;
import com.mindtree.StudentService.model.ResponseTemplate;
import com.mindtree.StudentService.repository.StudentRepository;

@Component
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public List<Student> listOfStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student findStudentByRollNo(long rollNo) {
		// TODO Auto-generated method stub
		return studentRepository.findByRollNo(rollNo);
	}

	@Override
	public ResponseTemplate studentWithCollege(long rollNo) {
		
		ResponseTemplate responseTemplate = new ResponseTemplate();
		Student student = studentRepository.findByRollNo(rollNo);
		
		long collegeId = student.getCollegeId();
		College college = restTemplate.getForObject("http://COLLEGE-SERVICE/college/"+collegeId, College.class);
		
		responseTemplate.setCollege(college);
		responseTemplate.setStudent(student);
		
		return responseTemplate;
	}

	@Override
	public Student assignToCollege(long rollNo, long collegeId) {

		Student student = studentRepository.findByRollNo(rollNo);
		College college = restTemplate.getForObject("http://COLLEGE-SERVICE/college/"+collegeId, College.class);
		
		if (student==null || college==null) {
			
			return null;
		}
		student.setCollegeId(collegeId);
		studentRepository.save(student);
		return student;
	}

	@Override
	public List<Student> getStudentsByCollegeId(long collegeId) {
		return studentRepository.getStudentsByCollegeId(collegeId);
	}

	@Override
	public List<Student> getStudentsByCollegeWithDescAge(long collegeId) {
		// TODO Auto-generated method stub
		return studentRepository.getStudentsByCollegeWithDescAge(collegeId);
	}

	@Override
	public List<Student> getStudentByStream(String stream) {
		List<Student> students = studentRepository.findAll();
		List<Student> select = new ArrayList<Student>();
		
		for(int i=0; i<students.size(); i++) {
			
			Student student = students.get(i);
			if (student.getStream().equals(stream))select.add(student);
				
		}
		Collections.sort(select, new sortbyage());
		return select;
	}

}
