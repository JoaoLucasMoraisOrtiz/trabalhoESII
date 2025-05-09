package com.example.myproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.myproject.dto.UnidadeDTO;

import com.example.myproject.service.UnidadeService;

@RequestMapping("/unidades")
@RestController
public class UnidadesController {
    private final UnidadeService unidadeService;

    public UnidadesController(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    @PostMapping
    public ResponseEntity<String> criarUnidade(@RequestBody UnidadeDTO dto) {
        try {
            unidadeService.createUnidade(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Unidade criada com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar unidade: " + e.getMessage());
        }
    }
}
