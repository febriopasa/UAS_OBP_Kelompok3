package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Donasi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DonasiRepository extends JpaRepository<Donasi, Integer> {
        // Query untuk mencari berdasarkan nama atau status

}