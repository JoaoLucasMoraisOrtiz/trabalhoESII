package com.example.myproject.model;

import jakarta.persistence.*;

@Entity

// Mesma coisa que aconteceu com a table pessoa, mas nesse caso, como é mais simples e bem menor a tabela, vamos colocar em uma tabela
// apenas, e ficar com espaços em branco, o que no fundo não tem tanto problema pois são campos de registro variável.
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double tamanho;

    public Long getId() {
        return id;
    }

    public double getTamanho() {
        return tamanho;
    }
    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }
}
