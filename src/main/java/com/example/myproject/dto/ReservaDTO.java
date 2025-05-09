package com.example.myproject.dto;

import java.time.LocalDate;

public class ReservaDTO {
    private Long id;
    private Long areaAlugavelId;
    private Long moradorId;
    private boolean ativa;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String descricao;
    private String statusReserva;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getAreaAlugavelId() { return areaAlugavelId; }
    public void setAreaAlugavelId(Long areaAlugavelId) { this.areaAlugavelId = areaAlugavelId; }
    public Long getMoradorId() { return moradorId; }
    public void setMoradorId(Long moradorId) { this.moradorId = moradorId; }
    public boolean isAtiva() { return ativa; }
    public void setAtiva(boolean ativa) { this.ativa = ativa; }
    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }
    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getStatusReserva() { return statusReserva; }
    public void setStatusReserva(String statusReserva) { this.statusReserva = statusReserva; }
}
