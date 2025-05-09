package com.example.myproject.mapper;

import com.example.myproject.dto.EspecificaDTO;
import com.example.myproject.model.Especifica;

public class EspecificaMapper {
    public static Especifica toEntity(EspecificaDTO dto) {
        Especifica entity = new Especifica();
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        return entity;
    }

    public static EspecificaDTO toDTO(Especifica entity) {
        EspecificaDTO dto = new EspecificaDTO();
        dto.setNome(entity.getNome());
        dto.setDescricao(entity.getDescricao());
        return dto;
    }
}
