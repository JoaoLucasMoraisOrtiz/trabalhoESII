package com.example.myproject.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Autorizacao {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    // trocar por uma visita
    private int idVisitaAgendada;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Morador Morador;

    private LocalDate dataHoraAutorizacao;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Visita visita;

    private StatusAutorizacao status;


    // Getters e Setters
    public Long getId() {
        return id;
    }

    public LocalDate getDataHoraAutorizacao() {
        return dataHoraAutorizacao;
    }
    public void setDataHoraAutorizacao(LocalDate dataHoraAutorizacao) {
        this.dataHoraAutorizacao = dataHoraAutorizacao;
    }

    public int getIdVisitaAgendada() {
        return idVisitaAgendada;
    }
    public void setIdVisitaAgendada(int idVisitaAgendada) {
        this.idVisitaAgendada = idVisitaAgendada;
    }

    public Morador getMorador() {
        return Morador;
    }
    public void setMorador(Morador morador) {
        Morador = morador;
    }

    public StatusAutorizacao getStatus() {
        return status;
    }
    public void setStatus(StatusAutorizacao status) {
        this.status = status;
    }

    public Visita getVisita() {
        return visita;
    }
    public void setVisita(Visita visita) {
        this.visita = visita;
    }
}
