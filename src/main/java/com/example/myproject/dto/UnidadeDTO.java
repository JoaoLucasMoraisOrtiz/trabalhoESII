package com.example.myproject.dto;

public class UnidadeDTO {
    private Long idUnidade;
    private String localizacao;
    private double tamanhoM2;

    public Long getIdUnidade() {
        return idUnidade;
    }
    public void setIdUnidade(Long idUnidade) {
        this.idUnidade = idUnidade;
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    public double getTamanhoM2() {
        return tamanhoM2;
    }
    public void setTamanhoM2(double tamanhoM2) {
        this.tamanhoM2 = tamanhoM2;
    }
}
