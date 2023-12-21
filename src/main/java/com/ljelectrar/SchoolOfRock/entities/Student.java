package com.ljelectrar.SchoolOfRock.entities;

import jakarta.persistence.*;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "tb_student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date birthDay;
    private Double fallWinterSemester;
    private Double springSummerSemester;
    private Double average;

    public Student() {
    }

    public Student(Long id, String name, Date birthDay, Double fallWinterSemester, Double springSummerSemester) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.fallWinterSemester = fallWinterSemester;
        this.springSummerSemester = springSummerSemester;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Double getFallWinterSemester() {
        return fallWinterSemester;
    }

    public Double getAverage() {
        return average;
    }

    public void setFallWinterSemester(Double fallWinterSemester) {
        this.fallWinterSemester = fallWinterSemester;
    }

    public Double getSpringSummerSemester() {
        return springSummerSemester;
    }

    public void setSpringSummerSemester(Double springSummerSemester) {
        this.springSummerSemester = springSummerSemester;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
