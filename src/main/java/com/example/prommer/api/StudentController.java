package com.example.prommer.api;

import com.example.prommer.model.users.Student;
import com.example.prommer.servic.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@Slf4j
@AllArgsConstructor
public class StudentController {

    private final StudentService studentServise;

    @GetMapping("/getStudents")
    public List<Student> findAllStudents() {
        return studentServise.findAllStudents();
    }

    @GetMapping("/getStudent/{studentId}")
    public Student getById(@PathVariable("studentId") Long studentId) {
        return studentServise.getStudentById(studentId);
    }

    @PutMapping("/edit/{id}")
    public Student updateStudent(@RequestParam("id") Long id, Student student) {
        return studentServise.updateStudent(id, student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudentById(@RequestParam("id") Long id) {
        studentServise.deleteStudentById(id);
    }
}
