package com.example.schooljournal.controller;

import com.example.schooljournal.entity.Student;
import com.example.schooljournal.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }

    @GetMapping("/class/{className}")
    public List<Student> getByClass(@PathVariable String className) {
        return service.getStudentsByClass(className);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }
}