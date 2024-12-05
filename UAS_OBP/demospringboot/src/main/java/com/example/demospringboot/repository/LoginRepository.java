package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {
    // Method untuk mencari user berdasarkan username
    Login findByUsername(String username);
}
