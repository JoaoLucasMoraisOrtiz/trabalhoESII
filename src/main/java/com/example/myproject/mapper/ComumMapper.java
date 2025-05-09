package com.example.myproject.mapper;

import com.example.myproject.dto.ComumDTO;
import com.example.myproject.model.Comum;

public class ComumMapper {
    public static Comum toEntity(ComumDTO dto) {
        Comum entity = new Comum() {
            // Classe anônima pois Comum é abstrata
        };
        entity.setLocalizacao(dto.getLocalizacao());
        return entity;
    }

    public static ComumDTO toDTO(Comum entity) {
        ComumDTO dto = new ComumDTO();
        dto.setLocalizacao(entity.getLocalizacao());
        return dto;
    }
}
