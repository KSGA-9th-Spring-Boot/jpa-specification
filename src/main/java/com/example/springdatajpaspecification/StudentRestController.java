package com.example.springdatajpaspecification;

import com.example.springdatajpaspecification.entitiy.Student;
import com.example.springdatajpaspecification.repository.StudentRepository;
import com.example.springdatajpaspecification.repository.spec.StudentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentRestController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("{universityId}")
    public List<Student> getStudents(@PathVariable long universityId) {
        StudentCriteria studentCriteria = new StudentCriteria();
        studentCriteria.setUniversityId(universityId);
        studentCriteria.setStudentName("b");
        StudentSpecification studentSpecification = new StudentSpecification(studentCriteria);
        return studentRepository.findAll(studentSpecification);
    }
}
