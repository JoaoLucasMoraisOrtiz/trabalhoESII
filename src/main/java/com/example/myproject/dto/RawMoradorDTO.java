package com.example.myproject.dto;

import java.time.LocalDate;
import java.util.List;

public class RawMoradorDTO {
    // Dados de Pessoa
    private String nome;
    private String cpf;
    private LocalDate dataNascimento; // ou LocalDate, se preferir

    // Dados de Morador
    private String tipoMorador; // ou TipoMorador, se já vier como enum
    private List<Long> unidade; // ID da unidade onde o morador reside

    // Dados de Contato
    private String telefoneResidencial;
    private String telefoneComercial;
    private String celular;
    private String email;

    // Dados de Acesso
    private String usuario;
    private String senha;

    // Endereço (apenas o ID, pois já deve existir)
    private List<Long> enderecoId;

    // Getters e setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTipoMorador() {
        return tipoMorador;
    }
    public void setTipoMorador(String tipoMorador) {
        this.tipoMorador = tipoMorador;
    }

    public List<Long> getUnidadeId() {
        return unidade;
    }
    public void setUnidadeId(List<Long> unidade) {
        this.unidade = unidade;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }
    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getTelefoneComercial() {
        return telefoneComercial;
    }
    public void setTelefoneComercial(String telefoneComercial) {
        this.telefoneComercial = telefoneComercial;
    }

    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Long> getEnderecoId() {
        return enderecoId;
    }
    public void setEnderecoId(List<Long> enderecoId) {
        this.enderecoId = enderecoId;
    }

}