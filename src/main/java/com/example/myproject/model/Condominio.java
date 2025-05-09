package com.example.myproject.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Condominio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoCondominio tipo;


    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Endereco> endereco = new ArrayList<>();


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Area> area = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Unidade> unidade = new ArrayList<>();
    

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }
    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoCondominio getTipo() {
        return tipo;
    }
    public void setTipo(TipoCondominio tipo) {
        this.tipo = tipo;
    }

    public List<Area> getArea() {
        return area;
    }
    public void setArea(List<Area> area) {
        this.area = area;
    }
    
    public List<Unidade> getUnidade() {
        return unidade;
    }
    public void setUnidade(List<Unidade> unidade) {
        this.unidade = unidade;
    }
}