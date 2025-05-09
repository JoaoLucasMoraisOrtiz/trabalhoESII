package com.example.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myproject.model.Visita;

public interface VisitaRepository extends JpaRepository<Visita, Long> {
}
