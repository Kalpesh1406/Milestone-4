package com.mindtree.StudentService;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.mindtree.StudentService.entity.Student;
import com.mindtree.StudentService.repository.StudentRepository;
import com.mindtree.StudentService.service.StudentService;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentService studentService;
	
	@BeforeEach
	void setUp() {
		studentRepository.deleteAll();
	}
	
	@Test
	void testStudentList() throws Exception {
		List<Student>  list= new ArrayList<>();
		list.add(new Student(1, "kalpesh", "male", 23,"Arts",1));
		list.add(new Student(1, "aditya", "male", 25,"Science",1));

		studentRepository.saveAll(list);
		
		ResultActions resultActions = mockMvc.perform(get("http://localhost:8065/student"));
		
		resultActions.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.size()", is(list.size())));
	}
}
