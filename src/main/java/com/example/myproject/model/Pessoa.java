package com.example.myproject.model;

// biblioteca necessária para trabalharmos com anotações JPA
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

// Anotação que indica que a classe é uma entidade JPA
// e que será mapeada para uma tabela no banco de dados
// A anotação @Entity é parte do pacote jakarta.persistence
// que é uma especificação padrão para persistência de dados em Java
@Entity
// Entretanto temos um problema no caso dessa classe em específico. Ela é uma classe abstrata. Nunca vamos instanciar apenas pessoa,
// sempre a pessoa será proprietário, ou morador, ou funcionário, ou visitante. Assim sendo, precisamos lidar com isso no banco de dados também
@Inheritance(strategy = InheritanceType.JOINED)
// A anotação @Inheritance indica que a classe Pessoa é uma superclasse
// e que as subclasses (como Proprietario, Morador, Funcionario e Visitante)
// serão mapeadas para tabelas separadas no banco de dados
// A estratégia InheritanceType.JOINED indica que as subclasses
// serão armazenadas em tabelas separadas, mas compartilharão
// a mesma chave primária da superclasse
public abstract class Pessoa {
    private String nome;

    // A anotação @Id indica que este campo é a chave primária da entidade
    // A anotação @GeneratedValue indica que o valor da chave primária
    // será gerado automaticamente pelo banco de dados
    // A estratégia GenerationType.IDENTITY indica que o banco de dados
    // irá gerar o valor da chave primária
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long idPessoa;

    // A anotação @Column é usada para especificar detalhes da coluna
    // como o nome da coluna no banco de dados
    // e se ela pode ser nula ou não
    // A anotação @Column é parte do pacote jakarta.persistence
    @Column(unique = true, nullable = false)
    private String cpf;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    // A anotação @OneToOne indica que existe um relacionamento
    // um-para-um entre a entidade Pessoa e a entidade Contato
    // A anotação @Cascade é usada para especificar o comportamento
    // de cascata para operações de persistência (deletar, salvar, etc.)
    // A anotação CascadeType.ALL indica que todas as operações
    // de persistência devem ser aplicadas à entidade relacionada
    // A anotação @Fetch é usada para especificar o tipo de busca
    // que será realizada para carregar a entidade relacionada
    // Pode ser de dois tipos: EAGER ou LAZY
    // EAGER significa que a entidade relacionada será carregada
    // imediatamente junto com a entidade principal
    // LAZY significa que a entidade relacionada será carregada
    // somente quando for acessada pela primeira vez
    // A anotação @OneToOne é parte do pacote jakarta.persistence
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Contato contato;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Acesso acesso;

    // nesse caso o cascade é persist. Assim, ao salvar uma pessoa, os endereços novos são salvos, mas ao deletar a pessoa, os endereços permanecem.
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Endereco> endereco = new ArrayList<>();

    // Getters e Setters

    public Long getId() {
        return idPessoa;
    }

    public void setId(Long id) {
        this.idPessoa = id;
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
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Acesso getAcesso() {
        return acesso;
    }
    public void setAcesso(Acesso acesso) {
        this.acesso = acesso;
    }

    public Contato getContato() {
        return contato;
    }
    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }
    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }
}