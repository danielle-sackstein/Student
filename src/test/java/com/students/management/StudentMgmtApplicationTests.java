package com.students.management;

import com.students.management.exceptions.StudentNotFound;
import com.students.management.persistence.entities.Student;
import com.students.management.persistence.jpa.StudentRepository;
import com.students.management.rest.StudentController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * This class tests JPA StudentRepository.
 * It loads 2 students with LoadDatabase class which is called by Spring.
 */
@SpringBootTest
class StudentMgmtApplicationTests {
	
	@Autowired
	private StudentRepository studentRepository;
	
	private StudentController studentController;
	
	@BeforeEach
	void setUp() {
		this.studentController = new StudentController(studentRepository);
	}
	
	/**
	 * Checks that students 1 and 2 are received from StudentController.
	 */
	@Test
	void test1() {
		
		studentRepository.save(new Student(1, "student1"));
		studentRepository.save(new Student(2, "student2"));
		
		// students are load with "LoadDatabase" class which is called by Spring
		Student student1 = studentController.getStudent(1);
		Assertions.assertEquals("student1", student1.getName());
		Assertions.assertEquals(1, student1.getId());
		
		Student student2 = studentController.getStudent(2);
		Assertions.assertEquals("student2", student2.getName());
		Assertions.assertEquals(2, student2.getId());
	}
	
	/**
	 * Asserts that method throws exception when student is not found.
	 */
	@Test()
	void test2() {
		int id = 3;
		
		assertThatThrownBy(() -> studentController.getStudent(id))
			.isInstanceOf(StudentNotFound.class);
	}
}
