package com.students.management.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class StudentNotFound extends ResponseStatusException {
    
    public StudentNotFound(int id) {
        super(HttpStatus.NOT_FOUND, String.format("Could not found student with id: %d", id));
    }
}
