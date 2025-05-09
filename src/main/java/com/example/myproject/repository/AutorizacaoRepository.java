package com.example.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myproject.model.Autorizacao;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long> {
}
