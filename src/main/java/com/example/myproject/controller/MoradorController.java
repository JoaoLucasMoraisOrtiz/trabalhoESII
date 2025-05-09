package com.example.myproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myproject.dto.RawMoradorDTO;
import com.example.myproject.model.Morador;
import com.example.myproject.service.MoradorService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/moradores")
public class MoradorController {

    private final MoradorService MoradorService;

    public MoradorController(MoradorService MoradorService) {
        this.MoradorService = MoradorService;
    }

    @PostMapping
    public ResponseEntity<String> criarMorador(@RequestBody RawMoradorDTO dto) {
        try {
            MoradorService.createMorador(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Morador criado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar morador: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Object> getMethodName() {
        try{
            List<Morador> moradores =  MoradorService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(moradores);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao encontrar moradores: " + e.getMessage());
        }

    }
    
}