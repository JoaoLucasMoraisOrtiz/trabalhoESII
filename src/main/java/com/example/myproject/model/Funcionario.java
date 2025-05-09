package com.example.myproject.model;

import jakarta.persistence.Entity;

@Entity
public class Funcionario extends Pessoa {

    private Long matricula;

    public Long getMatricula() {
        return matricula;
    }
    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }
}