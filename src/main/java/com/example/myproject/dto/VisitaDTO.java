package com.example.myproject.dto;

import java.time.LocalDate;

public class VisitaDTO {
    private Long id;
    private String nomeVisitante;
    private LocalDate dataVisita;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNomeVisitante() { return nomeVisitante; }
    public void setNomeVisitante(String nomeVisitante) { this.nomeVisitante = nomeVisitante; }
    public LocalDate getDataVisita() { return dataVisita; }
    public void setDataVisita(LocalDate dataVisita) { this.dataVisita = dataVisita; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
