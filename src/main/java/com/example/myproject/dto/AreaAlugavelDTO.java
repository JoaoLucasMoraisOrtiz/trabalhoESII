package com.example.myproject.dto;

import java.time.LocalDate;

public class AreaAlugavelDTO {

    private Long id;
    private Integer limitePessoas;
    private boolean disponivel;
    private LocalDate disponivelAte;
    private LocalDate disponivelDe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
