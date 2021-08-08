package com.students.management;

import com.students.management.persistence.jpa.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = StudentRepository.class)
@SpringBootApplication
public class StudentMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentMgmtApplication.class, args);
	}
}
