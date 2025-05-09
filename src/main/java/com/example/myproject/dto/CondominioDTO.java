package com.example.myproject.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.myproject.model.Area;
import com.example.myproject.model.Endereco;
import com.example.myproject.model.TipoCondominio;
import com.example.myproject.model.Unidade;

public class CondominioDTO {

    private Long id;

    private String nome;

    private TipoCondominio tipo;

    private List<Endereco> endereco = new ArrayList<>();

    private List<Area> area = new ArrayList<>();

    private List<Unidade> unidade = new ArrayList<>();

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
