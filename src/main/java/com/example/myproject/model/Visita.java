package com.example.myproject.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Visita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Visitante visitante;

    private LocalDate entrada;
    private LocalDate saida;
    private StatusVisita status;


    public LocalDate getEntrada() {
        return entrada;
    }
    public void setEntrada(LocalDate entrada) {
        this.entrada = entrada;
    }

    public Long getId() {
        return id;
    }
    
    public LocalDate getSaida() {
        return saida;
    }
    public void setSaida(LocalDate saida) {
        this.saida = saida;
    }

    public StatusVisita getStatus() {
        return status;
    }
    public void setStatus(StatusVisita status) {
        this.status = status;
    }

    public Visitante getVisitante() {
        return visitante;
    }
    public void setVisitante(Visitante visitante) {
        this.visitante = visitante;
    }

}