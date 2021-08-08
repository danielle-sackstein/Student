## Home Assignment - Student Manager

### Introduction 
This project is a JAVA REST PI which stores students in 'in memory' DB using JPA API.
Contains two REST HTTP methods:
 
1. GET /students/{id} - Searches and returns student info with given id. If not found throws a "StudentNotFound" Runtime Exception.
2. POST /students with JSON body Student - Inserts a new student into the DB


### Overview 

- Spring Framework which enables easy REST endpoint mapping, configuration system.
- Maven for dependency management.
- JPA for DB storage
- JUnit testing framework for tests.

### Running the application

Build with: 
```mvn clean install```

Run with:

```java -jar target/students.management-1.0.0-SNAPSHOT.jar```