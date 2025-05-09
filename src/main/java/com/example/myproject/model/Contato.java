package com.example.myproject.model;

// biblioteca necessária para trabalharmos com anotações JPA
import jakarta.persistence.*;

@Entity
public class Contato {
    private String telefoneResidencial;
    private String telefoneComercial;
    private String celular;
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


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

    public String getTelefoneComercial() {
        return telefoneComercial;
    }
    public void setTelefoneComercial(String telefoneComercial) {
        this.telefoneComercial = telefoneComercial;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }
    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public Long getId() {
        return id;
    }
}
