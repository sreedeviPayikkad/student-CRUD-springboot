package io.springbootprojects.studentservices.controllers;

import io.springbootprojects.studentservices.model.Student;
import io.springbootprojects.studentservices.services.StudentApiServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentServicesController {
    private static final Logger logger = LoggerFactory.getLogger(StudentServicesController.class);

    @Autowired
    StudentApiServices studentApiServices;

    @GetMapping(path = "/api/v1/student")

    public List<Student> getAllStudents() {
        logger.info("gathering info about all students");
        return studentApiServices.getAllStudents();
    }

    @PostMapping(path = "/api/v1/student/add")
    public String addStudentWithEmail(@RequestBody Student student) {
        return studentApiServices.addStudent(student);

    }

    @DeleteMapping(path = "/api/v1/student/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        return studentApiServices.deleteByStudentId(id);
    }

    @PutMapping(path = "/api/v1/student/update/{id}")
    public String updateNameAndEmail(@PathVariable Long id, @RequestParam(required = false) String name, @RequestParam(required = false) String email) {
        return studentApiServices.updateStudent(id, name, email);
    }

}
