package com.example.myproject.dto;

import java.time.LocalDate;

public class AutorizacaoDTO {
    private Long id;
    private int idVisitaAgendada;
    private Long moradorId;
    private LocalDate dataHoraAutorizacao;
    private Long visitaId;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getIdVisitaAgendada() { return idVisitaAgendada; }
    public void setIdVisitaAgendada(int idVisitaAgendada) { this.idVisitaAgendada = idVisitaAgendada; }
    public Long getMoradorId() { return moradorId; }
    public void setMoradorId(Long moradorId) { this.moradorId = moradorId; }
    public LocalDate getDataHoraAutorizacao() { return dataHoraAutorizacao; }
    public void setDataHoraAutorizacao(LocalDate dataHoraAutorizacao) { this.dataHoraAutorizacao = dataHoraAutorizacao; }
    public Long getVisitaId() { return visitaId; }
    public void setVisitaId(Long visitaId) { this.visitaId = visitaId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
