package com.example.prommer.servic;

import com.example.prommer.model.users.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAllStudents ();

    Student getStudentById(Long id);

    Student updateStudent(Long id, Student student);

    void deleteStudentById(Long id);


}
