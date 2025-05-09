package com.example.myproject.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Morador extends Pessoa {

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Unidade> unidade = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Cobranca cobranca;

    @Enumerated(EnumType.STRING)
    private TipoMorador tipoMorador;


    public Morador() {
    }
    public Morador(List<Unidade> unidade, Cobranca cobranca, TipoMorador tipoMorador) {
        this.unidade = unidade;
        this.cobranca = cobranca;
        this.tipoMorador = tipoMorador;
    }

    public List<Unidade> getUnidade() {
        return unidade;
    }

    public void setUnidade(List<Unidade> unidade) {
        this.unidade = unidade;
    }

    public Cobranca getCobranca() {
        return cobranca;
    }

    public void setCobranca(Cobranca cobranca) {
        this.cobranca = cobranca;
    }

    public TipoMorador getTipoMorador() {
        return tipoMorador;
    }
    public void setTipoMorador(TipoMorador tipoMorador) {
        this.tipoMorador = tipoMorador;
    }
}
