package com.example.prommer.servic.serviseImpl;

import com.example.prommer.exceptions.DoesNotExistsException;
import com.example.prommer.model.users.Student;
import com.example.prommer.repository.StudentRepository;
import com.example.prommer.servic.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudents() {

        return Optional.of(studentRepository.findAll())
                .orElseThrow(() -> new DoesNotExistsException(
                        "students with  has already exists"
                ));
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new DoesNotExistsException(
                        "student with id: " + studentId + "does not exists"
                ));
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student student2 = studentRepository.findById(id)
                .orElseThrow(() -> new DoesNotExistsException(
                        "student with id = " + id + " does not exists"
                ));
        Optional<Student> studentOptional = studentRepository.findByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            log.error("vendor with email {} has already exists", student.getEmail());
            throw new DoesNotExistsException(
                    "student with email: " + student.getEmail() + " has already exists"
            );
        }
        student2.setLanguage(student.getLanguage());
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
//
//                .orElseThrow(() -> new DoesNotExistsException(
//                        "student with id: " + id + "does not exists"));
//    }
    }
}