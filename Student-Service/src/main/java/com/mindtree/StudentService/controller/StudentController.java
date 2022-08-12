package com.mindtree.StudentService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mindtree.StudentService.entity.Student;
import com.mindtree.StudentService.model.ResponseTemplate;
import com.mindtree.StudentService.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		
		return studentService.addStudent(student);
	}
	
	@GetMapping
	public List<Student> listOfStudents() {
		
		return studentService.listOfStudents();
	}
	
	@GetMapping("/{rollNo}")
	public ResponseTemplate studentWithCollege(@PathVariable long rollNo) {
		return studentService.studentWithCollege(rollNo);
	}
	
	@PutMapping("/{rollNo}/{collegeId}")
	public String assignToCollege(@PathVariable long rollNo, @PathVariable long collegeId) {
		
		Student student = studentService.assignToCollege(rollNo, collegeId);
		if (student!=null) {
			return student.toString();
			
		}
		return "College or Student Not Found...!";
	}
	
	@GetMapping("/studASC/{collegeId}")
	public List<Student> getStudentsByCollegeId(@PathVariable long collegeId) {
		return studentService.getStudentsByCollegeId(collegeId);
	}
	
	@GetMapping("/studDESC/{collegeId}")
	public List<Student> getStudentsByCollegeWithDescAge(@PathVariable long collegeId) {
		return studentService.getStudentsByCollegeWithDescAge(collegeId);
	}
	
	@GetMapping("/stream/{stream}")
	public List<Student> getStudentByStream(@PathVariable(value = "stream") String stream) {
		return this.studentService.getStudentByStream(stream);
		
	}


}
