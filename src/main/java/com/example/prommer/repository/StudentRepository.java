package com.example.prommer.repository;

import com.example.prommer.model.users.Admin;
import com.example.prommer.model.users.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT c FROM Student c WHERE c.email = ?1")
    Optional<Student> findByEmail(String email);


}
