package com.example.schooljournal.controller;

import com.example.schooljournal.entity.Subject;
import com.example.schooljournal.service.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService service;

    public SubjectController(SubjectService service) {
        this.service = service;
    }

    @PostMapping
    public Subject addSubject(@RequestBody Subject subject) {
        return service.addSubject(subject);
    }

    @GetMapping
    public List<Subject> getAll() {
        return service.getAllSubjects();
    }
}