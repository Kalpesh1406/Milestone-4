package com.mindtree.CollegeService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.CollegeService.entity.College;
import com.mindtree.CollegeService.model.RequestTemplate;

@Service
public interface CollegeService {
	
	College addCollege(College college);
	List<College> listOfColleges();
	College updateCollege(long id, String clgName);
	College findById(long id);
	List<RequestTemplate> listWithStudent();
	RequestTemplate perticularCollegeStudent(long collegeId);

}
