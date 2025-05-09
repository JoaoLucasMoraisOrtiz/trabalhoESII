package com.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;


// Classe principal da aplicação Spring Boot, é sinalizada pela anotação @SpringBootApplication
// e contém o método main que inicia a aplicação.
@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(MyApplication.class, args);
    }
}
