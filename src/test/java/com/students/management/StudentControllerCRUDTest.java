package com.students.management;

import com.students.management.exceptions.StudentNotFound;
import com.students.management.persistence.entities.Student;
import com.students.management.persistence.jpa.StudentRepository;
import com.students.management.rest.StudentController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * This class mocks StudentRepository and tests only StudentController.
 */
public class StudentControllerCRUDTest {
    
    private StudentRepository studentDB;
    private StudentController studentController;
    
    @BeforeEach
    void setUp() {
        this.studentDB = mock(StudentRepository.class);
        this.studentController = new StudentController(studentDB);
    }
    
    /**
     * Adds one student and receives it by id.
     */
    @Test
    void test1() {
        int id = 1;
        String name = "test-student";
        
        Student expected = new Student(id, name);
        
        when(studentDB.save(any(Student.class)))
            .thenAnswer(onMock -> onMock.getArgument(0)); // return same student
        when(studentDB.findById(anyInt()))
            .thenReturn(Optional.of(expected));
    
        studentController.createStudent(expected);
        Student actual = studentController.getStudent(id);
    
        Assertions.assertEquals(expected, actual);
    }
    
    /**
     * Asserts that method throws exception when student is not found.
     */
    @Test()
    void test2() {
        int id = 1;
    
        assertThatThrownBy(() -> studentController.getStudent(id))
            .isInstanceOf(StudentNotFound.class);
    }
}
