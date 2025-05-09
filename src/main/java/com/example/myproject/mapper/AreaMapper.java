package com.example.myproject.mapper;

import com.example.myproject.dto.AreaDTO;
import com.example.myproject.model.Area;

public class AreaMapper {
    public static Area toEntity(AreaDTO dto) {
        Area entity = new Area() {
            // Classe anônima pois Area é abstrata
        };
        entity.setTamanho(dto.getTamanho());
        return entity;
    }

    public static AreaDTO toDTO(Area entity) {
        AreaDTO dto = new AreaDTO();
        dto.setId(entity.getId());
        dto.setTamanho(entity.getTamanho());
        return dto;
    }
}
