package io.springbootprojects.studentservices.services;

import io.springbootprojects.studentservices.model.Student;
import io.springbootprojects.studentservices.model.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentApiServices {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(Student s) {
        Optional<Student> student;
        student = findStudentByEmailId(s.getEmail());
        if (student.isPresent()) throw new IllegalStateException("student with this email already present");
        else studentRepository.save(s);

        // Student newStudent = new Student("John", LocalDate.of(1992, 8, 22), "john123@gmail.com");
        //studentRepository.save(newStudent);
        return "student added";
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    private Optional<Student> findStudentByEmailId(String email) {
        Optional<Student> s = studentRepository.findStudentByEmail(email);
        System.out.println(s);
        return s;
    }

    public String deleteByStudentId(Long id) {
        Optional<Student> s = studentRepository.findById(id);
        if (s.isPresent()) {
            studentRepository.deleteById(id);
            return "student deleted";
        }
        return "student not found";
    }


    @Transactional
    public String updateStudent(Long id, String name, String email) {
        //check if student with this id exists
        Optional<Student> student = studentRepository.findById(id);
        Optional<Student> s = studentRepository.findStudentByEmail(email);
        if (student.isPresent() && s.isEmpty()) {
            student.get().setName(name);
            student.get().setEmail(email);
            return "student updated";
        }
        return "student not found";
    }
}
