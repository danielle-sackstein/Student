package com.students.management.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Entity
public class Student {
    private final @Id int id;
    private final String name;
}
