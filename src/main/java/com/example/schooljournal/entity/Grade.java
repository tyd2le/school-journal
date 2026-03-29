package com.example.schooljournal.entity;

import jakarta.persistence.*;

@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int value;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Subject subject;

    // getters/setters
    public Long getId() { return id; }

    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Subject getSubject() { return subject; }
    public void setSubject(Subject subject) { this.subject = subject; }
}