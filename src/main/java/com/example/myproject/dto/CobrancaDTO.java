package com.example.myproject.dto;

import java.time.LocalDate;

public class CobrancaDTO {
    private Long id;
    private double valor;
    private LocalDate dataEmissao;
    private LocalDate dataVencimento;
    private String status;
    private Long pagamentoId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
    public LocalDate getDataEmissao() { return dataEmissao; }
    public void setDataEmissao(LocalDate dataEmissao) { this.dataEmissao = dataEmissao; }
    public LocalDate getDataVencimento() { return dataVencimento; }
    public void setDataVencimento(LocalDate dataVencimento) { this.dataVencimento = dataVencimento; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Long getPagamentoId() { return pagamentoId; }
    public void setPagamentoId(Long pagamentoId) { this.pagamentoId = pagamentoId; }
}
