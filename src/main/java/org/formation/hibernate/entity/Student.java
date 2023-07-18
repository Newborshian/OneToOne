package org.formation.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String enrollmentId;
    private String name;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "professor_id")
    private Professor professor;

    public Student() {
    }

    public Student(String enrollmentId, String name, Professor professor) {
        this.enrollmentId = enrollmentId;
        this.name = name;
        this.professor = professor;
    }

    public Student(String enrollmentId, String name) {
        this.enrollmentId = enrollmentId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "enrollmentId='" + enrollmentId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
