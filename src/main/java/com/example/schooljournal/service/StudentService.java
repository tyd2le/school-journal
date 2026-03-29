package com.example.schooljournal.service;

import com.example.schooljournal.entity.Student;
import com.example.schooljournal.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student addStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getStudentsByClass(String className) {
        return repository.findByClassName(className);
    }
}