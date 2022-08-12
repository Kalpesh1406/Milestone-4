package com.mindtree.StudentService;

import static org.assertj.core.api.Assertions.assertThat; 

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.StudentService.entity.Student;
import com.mindtree.StudentService.repository.StudentRepository;

@SpringBootTest
class StudentApplicationTests {

	@Autowired
	StudentRepository studentRepository ;
	
	@Test
	void testReadAll() {
		List<Student> list = studentRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
		
	}

}
