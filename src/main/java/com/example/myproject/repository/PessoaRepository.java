package com.example.myproject.repository;

// imorta a classe que queremos trabalhar
import com.example.myproject.model.Pessoa;

// importa a biblioteca que precisamos para trabalhar com o banco de dados
import org.springframework.data.jpa.repository.JpaRepository;


// quando criamos isso, é basicamente o mesmo que criar um CRUD
// no laravel model e repository são uma coisa só nos models, aqui não.
// essa aqui pe a classe que vai fazer a conexão com o banco de dados, que pode ser uma classe abstrata
// e ela vai extender a classe JpaRepository, que é uma classe do Spring Data JPA
// que fornece métodos prontos para operações de CRUD (Create, Read, Update, Delete)
// o JpaRepository é uma interface genérica que recebe dois parâmetros:
// 1. A entidade que estamos trabalhando (Pessoa)
// 2. O tipo da chave primária da entidade (Long)
// o JpaRepository é parte do pacote org.springframework.data.jpa.repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    // Aqui podemos adicionar métodos personalizados de consulta, se necessário
    // Por exemplo, podemos adicionar um método para encontrar uma pessoa pelo CPF
    // public Optional<Pessoa> findByCpf(String cpf);
    
}
