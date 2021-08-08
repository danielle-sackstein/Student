package com.students.management.persistence.jpa;

import com.students.management.persistence.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
