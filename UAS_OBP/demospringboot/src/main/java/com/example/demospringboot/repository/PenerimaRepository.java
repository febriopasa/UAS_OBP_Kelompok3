package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Penerima;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PenerimaRepository extends JpaRepository<Penerima, Integer> {
}