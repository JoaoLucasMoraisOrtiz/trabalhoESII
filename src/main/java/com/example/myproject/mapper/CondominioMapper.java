package com.example.myproject.mapper;

import com.example.myproject.dto.CondominioDTO;
import com.example.myproject.model.Condominio;

public class CondominioMapper {
    public static Condominio toEntity(CondominioDTO dto) {
        Condominio entity = new Condominio();
        entity.setNome(dto.getNome());
        entity.setTipo(dto.getTipo());
        // Endereços, áreas e unidades devem ser setados via service
        return entity;
    }

    public static CondominioDTO toDTO(Condominio entity) {
        CondominioDTO dto = new CondominioDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setTipo(entity.getTipo());
        // Endereços, áreas e unidades podem ser setados via service
        return dto;
    }
}
