package com.example.schooljournal.service;

import com.example.schooljournal.entity.Subject;
import com.example.schooljournal.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository repository;

    public SubjectService(SubjectRepository repository) {
        this.repository = repository;
    }

    public Subject addSubject(Subject subject) {
        return repository.save(subject);
    }

    public List<Subject> getAllSubjects() {
        return repository.findAll();
    }
}