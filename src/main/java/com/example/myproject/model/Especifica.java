package com.example.myproject.model;

import jakarta.persistence.Entity;

@Entity
public class Especifica extends Area {

    private String nome;
    private String descricao;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
