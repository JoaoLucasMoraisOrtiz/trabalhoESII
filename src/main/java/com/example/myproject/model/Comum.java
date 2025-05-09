package com.example.myproject.model;

import jakarta.persistence.Entity;

@Entity
public abstract class Comum extends Area{
    private String localizacao;

    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
