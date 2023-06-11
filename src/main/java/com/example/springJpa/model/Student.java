package com.example.springJpa.model;

import jakarta.persistence.*;
@Entity
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studId;
    @Column(name="fname")
    private String firstName;
    @Column(name = "lname")
    private String lastName;
    @Column(name = "age")
    private int age;


    public Student(int studId, String firstName, String lastName, int age) {
        this.studId = studId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Student() {

    }


    public int getStudId() {
        return studId;
    }

    public void setStudId(int studId) {
        this.studId = studId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studId=" + studId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
