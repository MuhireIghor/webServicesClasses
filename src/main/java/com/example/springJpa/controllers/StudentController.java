package com.example.springJpa.controllers;

import com.example.springJpa.model.Student;
import com.example.springJpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1")
public class StudentController {
    @Autowired
    public StudentRepository studentRepo;

    @GetMapping(path = "/students")
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    @GetMapping(path = "/students/{studId}")
    public Optional<Student> getStudentById(@PathVariable("studId") int studId) {
        return studentRepo.findById(studId);
    }

    @GetMapping(path = "/students/age/{age}")
    public List<Student> getStudentsByAge(@PathVariable("age") int age) {
        return studentRepo.findByAge(age);
    }
    @PutMapping(path = "/students/{studId}")
    public Student updateStudent(@PathVariable("studId") int studId,@RequestBody Student stud){
        Student foundStud = studentRepo.findById(studId).orElseThrow(() ->new IllegalStateException("Student with id"+ studId+" is not found"));
        foundStud.setAge(stud.getAge());
        foundStud.setFirstName(stud.getFirstName());
        foundStud.setLastName(stud.getLastName());
        studentRepo.save(foundStud);
        return foundStud;

    }
    @DeleteMapping(path = "/students/{studId}")
    public Student deleteStudent(@PathVariable("studId") int studId){
        Student deletedStudent = studentRepo.findById(studId).orElseThrow(()->new IllegalStateException("Student with id "+studId+" is not found")) ;
        studentRepo.deleteById(studId);
        return  deletedStudent;
    }

    @PostMapping(path = "students")
    public Student createStudent(@RequestBody Student studData){
        Optional<Student> foundStudent = studentRepo.findByFirstName(studData.getFirstName());
        if(foundStudent.isPresent()){
            throw new IllegalArgumentException("A student with the names"+studData.getFirstName()+ " already exists");
        }
        return studentRepo.save(studData);
    }
}