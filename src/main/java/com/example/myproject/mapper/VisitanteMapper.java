package com.example.myproject.mapper;

import com.example.myproject.dto.VisitanteDTO;
import com.example.myproject.model.Visitante;

public class VisitanteMapper {
    public static Visitante toEntity(VisitanteDTO dto) {
        Visitante entity = new Visitante();
        // Adicione campos específicos de VisitanteDTO aqui
        return entity;
    }

    public static VisitanteDTO toDTO(Visitante entity) {
        VisitanteDTO dto = new VisitanteDTO();
        // Adicione campos específicos de Visitante aqui
        return dto;
    }
}
