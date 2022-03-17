package com.example.prommer.repository;

import com.example.prommer.model.users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query("select b from Admin b where b.email = ?1")
    Admin findByEmail();
}
