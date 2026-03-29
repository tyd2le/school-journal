package com.example.schooljournal.controller;

import com.example.schooljournal.entity.Grade;
import com.example.schooljournal.service.GradeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sgrade")
public class GradeController {

    private final GradeService service;

    public GradeController(GradeService service) {
        this.service = service;
    }

    @PostMapping
    public Grade addGrade(@RequestParam Long studentId,
                          @RequestParam Long subjectId,
                          @RequestParam int value) {
        return service.addGrade(studentId, subjectId, value);
    }

    @GetMapping("/student/{studentId}")
    public List<Grade> getByStudent(@PathVariable Long studentId) {
        return service.getGradesByStudent(studentId);
    }
}