package com.example.myproject.dto;

import java.util.List;

public class RawProprietarioDTO extends PessoaDTO {

    // Dados de Morador
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
