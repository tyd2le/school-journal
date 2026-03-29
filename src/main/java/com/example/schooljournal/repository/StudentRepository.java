package com.example.schooljournal.repository;

import com.example.schooljournal.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByClassName(String className);
}