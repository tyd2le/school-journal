package com.example.schooljournal.service;

import com.example.schooljournal.entity.Grade;
import com.example.schooljournal.entity.Student;
import com.example.schooljournal.entity.Subject;
import com.example.schooljournal.repository.GradeRepository;
import com.example.schooljournal.repository.StudentRepository;
import com.example.schooljournal.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    private final GradeRepository gradeRepo;
    private final StudentRepository studentRepo;
    private final SubjectRepository subjectRepo;

    public GradeService(GradeRepository gradeRepo,
                        StudentRepository studentRepo,
                        SubjectRepository subjectRepo) {
        this.gradeRepo = gradeRepo;
        this.studentRepo = studentRepo;
        this.subjectRepo = subjectRepo;
    }

    public Grade addGrade(Long studentId, Long subjectId, int value) {
        Student student = studentRepo.findById(studentId).orElseThrow();
        Subject subject = subjectRepo.findById(subjectId).orElseThrow();

        Grade grade = new Grade();
        grade.setStudent(student);
        grade.setSubject(subject);
        grade.setValue(value);

        return gradeRepo.save(grade);
    }

    public List<Grade> getGradesByStudent(Long studentId) {
        return gradeRepo.findByStudentId(studentId);
    }
}