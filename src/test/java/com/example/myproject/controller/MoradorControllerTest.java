package com.example.myproject.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes=com.example.MyApplication.class)
@AutoConfigureMockMvc
public class MoradorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCriarMorador() throws Exception {
        String uniqueUser = "user" + System.currentTimeMillis();
        String uniqueCPF = "123.456.789-" + (int)(Math.random() * 100);
        String json = "{ \"nome\": \"João\", \"cpf\": \""+uniqueCPF+"\", \"dataNascimento\": \"1990-01-01\", \"tipoMorador\": \"PROPRIETARIO\", \"unidadeId\": [1], \"telefoneResidencial\": \"1122334455\", \"telefoneComercial\": \"1133445566\", \"celular\": \"11999998888\", \"email\": \"joao@email.com\", \"usuario\": \""+uniqueUser+"\", \"senha\": \"senha123\", \"enderecoId\": [1] }";

        mockMvc.perform(post("/moradores")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
    }
}