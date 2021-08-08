package com.students.management.rest;

import com.students.management.exceptions.StudentNotFound;
import com.students.management.persistence.jpa.StudentRepository;
import com.students.management.persistence.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public
class StudentController {
    
    private final StudentRepository repository;
    
    @Autowired
    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student getStudent(@PathVariable("id") int id) {
       return repository.findById(id)
            .orElseThrow(() -> new StudentNotFound(id));
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        return repository.save(student);
    }
}