package com.example.myproject.mapper;

import com.example.myproject.dto.AreaAlugavelDTO;
import com.example.myproject.model.AreaAlugavel;

public class AreaAlugavelMapper {
    public static AreaAlugavel toEntity(AreaAlugavelDTO dto) {
        AreaAlugavel entity = new AreaAlugavel();
        entity.setLimitePessoas(dto.getLimitePessoas());
        entity.setDisponivel(dto.isDisponivel());
        entity.setDisponivelAte(dto.getDisponivelAte());
        entity.setDisponivelDe(dto.getDisponivelDe());
        return entity;
    }

    public static AreaAlugavelDTO toDTO(AreaAlugavel entity) {
        AreaAlugavelDTO dto = new AreaAlugavelDTO();
        dto.setId(entity.getId());
        dto.setLimitePessoas(entity.getLimitePessoas());
        dto.setDisponivel(entity.isDisponivel());
        dto.setDisponivelAte(entity.getDisponivelAte());
        dto.setDisponivelDe(entity.getDisponivelDe());
        return dto;
    }
}
