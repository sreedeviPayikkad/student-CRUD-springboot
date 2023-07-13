package io.springbootprojects.studentservices.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Transient
    private int age;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "email", nullable = false)
    private String email;

    public Student() {
    }

    public Student(String name, LocalDate date, String email) {
        this.name = name;
        this.date = date;
        this.email = email;
    }

    public Student(long id, String name, LocalDate date, String email) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return Period.between(this.getDate(), LocalDate.now()).getYears();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }


}
