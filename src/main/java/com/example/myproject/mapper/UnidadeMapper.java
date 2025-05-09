package com.example.myproject.mapper;

import com.example.myproject.dto.UnidadeDTO;
import com.example.myproject.model.Unidade;

public class UnidadeMapper {
    public static Unidade toEntity(UnidadeDTO dto) {
        Unidade entity = new Unidade();
        entity.setLocalizacao(dto.getLocalizacao());
        entity.setTamanhoM2(dto.getTamanhoM2());
        return entity;
    }

    public static UnidadeDTO toDTO(Unidade entity) {
        UnidadeDTO dto = new UnidadeDTO();
        dto.setIdUnidade(entity.getIdUnidade());
        dto.setLocalizacao(entity.getLocalizacao());
        dto.setTamanhoM2(entity.getTamanhoM2());
        return dto;
    }
}
