package com.example.myproject.dto;

import jakarta.persistence.Entity;

@Entity
public class EspecificaDTO extends AreaDTO {

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