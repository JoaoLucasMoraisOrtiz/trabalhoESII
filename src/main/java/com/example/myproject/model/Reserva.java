package com.example.myproject.model;

import java.time.LocalDate;

import jakarta.persistence.*;


@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private AreaAlugavel areaAlugavel;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Morador morador;

    private boolean ativa;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String descricao;

    private StatusReserva statusReserva;


    public Long getId() {
        return id;
    }
    
    public LocalDate getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public AreaAlugavel getAreaAlugavel() {
        return areaAlugavel;
    }
    public void setAreaAlugavel(AreaAlugavel areaAlugavel) {
        this.areaAlugavel = areaAlugavel;
    }

    public Morador getMorador() {
        return morador;
    }
    public void setMorador(Morador morador) {
        this.morador = morador;
    }
    
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public StatusReserva getStatusReserva() {
        return statusReserva;
    }
    public void setStatusReserva(StatusReserva statusReserva) {
        this.statusReserva = statusReserva;
    }
}