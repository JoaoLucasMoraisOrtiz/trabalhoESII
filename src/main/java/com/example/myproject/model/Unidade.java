package com.example.myproject.model;

import jakarta.persistence.*;

@Entity
public class Unidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUnidade;

    private String localizacao;
    private double tamanhoM2;


    // Getters e Setters

    public Long getIdUnidade() {
        return idUnidade;
    }
    
    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public double getTamanhoM2() {
        return tamanhoM2;
    }
    public void setTamanhoM2(double tamanhoM2) {
        this.tamanhoM2 = tamanhoM2;
    }
}
