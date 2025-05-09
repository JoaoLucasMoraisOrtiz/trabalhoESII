package com.example.myproject.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.myproject.model.Acesso;
import com.example.myproject.model.Contato;
import com.example.myproject.model.Endereco;

public class PessoaDTO {

    private long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Contato contato;
    private Acesso acesso;
    private List<Endereco> endereco = new ArrayList<>();

    // Getters e Setters

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

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
        return dataNascimento == null ? null : dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Acesso getAcesso() {
        return acesso == null || acesso.getId() == null ? null : acesso;
    }
    public void setAcesso(Acesso acesso) {
        this.acesso = acesso;
    }

    public Contato getContato() {
        return contato == null || contato.getId() == null ? null : contato;
    }
    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public List<Endereco> getEndereco() {
        return endereco == null || endereco.getFirst().getId() == null ? null : endereco;
    }
    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }
}
