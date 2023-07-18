package org.formation.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String staffId;
    private String name;
    private Integer salary;
    @OneToMany(mappedBy = "professor", cascade = CascadeType.PERSIST)
    private Set<Student> students = new HashSet<Student>();

    public Professor(String staffId, String name, Integer salary) {
        this.staffId = staffId;
        this.name = name;
        this.salary = salary;
    }

    public Professor() {
    }
    public void addStudent(Student student){
        students.add(student);
        student.setProfessor(this);
    }

    public void removeStudent(Student student){
        students.remove(student);
        student.setProfessor(this);
    }

    @Override
    public String toString() {
        return "Professor{" +
                "name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
