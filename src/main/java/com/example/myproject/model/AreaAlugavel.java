package com.example.myproject.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity
public class AreaAlugavel extends Comum{

    private Integer limitePessoas;
    private boolean disponivel;
    private LocalDate disponivelAte;
    private LocalDate disponivelDe;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reserva> reserva = new ArrayList<>();




    public Integer getLimitePessoas() {
        return limitePessoas;
    }

    public void setLimitePessoas(Integer limitePessoas) {
        this.limitePessoas = limitePessoas;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public LocalDate getDisponivelAte() {
        return disponivelAte;
    }

    public void setDisponivelAte(LocalDate disponivelAte) {
        this.disponivelAte = disponivelAte;
    }

    public LocalDate getDisponivelDe() {
        return disponivelDe;
    }

    public void setDisponivelDe(LocalDate disponivelDe) {
        this.disponivelDe = disponivelDe;
    }

    public List<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(List<Reserva> reserva) {
        this.reserva = reserva;
    }
}
