package com.mindtree.CollegeService.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mindtree.CollegeService.entity.College;
import com.mindtree.CollegeService.model.RequestTemplate;
import com.mindtree.CollegeService.model.Student;
import com.mindtree.CollegeService.repository.CollegeRepository;

@Component
public class CollegeServiceImpl implements CollegeService{

	@Autowired
	CollegeRepository collegeRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	
	@Override
	public College addCollege(College college) {
		// TODO Auto-generated method stub
		return collegeRepository.save(college);
	}

	@Override
	public List<College> listOfColleges() {
		// TODO Auto-generated method stub
		return collegeRepository.findAll();
	}

	@Override
	public College updateCollege(long id, String clgName) {
		
		College college = collegeRepository.findById(id);
		college.setClgName(clgName);
		return collegeRepository.save(college);
	}

	@Override
	public College findById(long id) {

		if(collegeRepository.findById(id)==null) {
			return null;
		}
		return collegeRepository.findById(id);
	}

	@Override
	public List<RequestTemplate> listWithStudent() {

		List<RequestTemplate> list = new ArrayList<RequestTemplate>();
		List<College> colleges = this.listOfColleges();
		Iterator<College> iterator = colleges.iterator();
		while (iterator.hasNext()) {
			College college =  iterator.next();
			ResponseEntity<Student[]> responseEntity = restTemplate.getForEntity("http://STUDENT-SERVICE/student/studASC/"+college.getId(), Student[].class);
			Student[] students = responseEntity.getBody();
			List<Student> students2 = Arrays.asList(students);
			
			RequestTemplate requestTemplate = new RequestTemplate();
			requestTemplate.setCollege(college);
			requestTemplate.setStudentsList(students2);
			list.add(requestTemplate);
		}
		return list;
	}

	@Override
	public RequestTemplate perticularCollegeStudent(long collegeId) {

		College college = this.findById(collegeId);
		ResponseEntity<Student[]> responseEntity = restTemplate.getForEntity("http://STUDENT-SERVICE/student/studDESC/"+college.getId(), Student[].class);
		Student[] students = responseEntity.getBody();
		List<Student> students2 = Arrays.asList(students);
		
		RequestTemplate requestTemplate = new RequestTemplate();
		requestTemplate.setCollege(college);
		requestTemplate.setStudentsList(students2);
		return requestTemplate;
	}

}
