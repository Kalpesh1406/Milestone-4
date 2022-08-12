package com.mindtree.CollegeService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.CollegeService.entity.College;
import com.mindtree.CollegeService.model.RequestTemplate;
import com.mindtree.CollegeService.service.CollegeService;

@RestController
@RequestMapping("/college")
public class CollegeController {
	
	@Autowired
	CollegeService collegeService;

	@PostMapping
	public College addCollege(@RequestBody College college) {
		return collegeService.addCollege(college);
	}
	
	@GetMapping
	public List<College> listOfColleges() {
		return collegeService.listOfColleges();
	}

	@GetMapping("/{id}")
	public College findById(@PathVariable long id) {
		return collegeService.findById(id);
	}

	@GetMapping("/collegeWithStudent")
	public List<RequestTemplate> listWithStudent() {
		return collegeService.listWithStudent();
		
	}
	
	@GetMapping("/collegeWithStudent/{collegeId}")
	public RequestTemplate perticularCollegeStudent(@PathVariable long collegeId) {
		return collegeService.perticularCollegeStudent(collegeId);
		
	}


}
