package com.example.myproject.mapper;

import com.example.myproject.dto.VisitaDTO;
import com.example.myproject.model.Visita;

public class VisitaMapper {
    public static Visita toEntity(VisitaDTO dto) {
        Visita entity = new Visita();
        entity.setEntrada(dto.getDataVisita()); // Ajuste conforme seu domínio
        entity.setStatus(dto.getStatus() != null ? com.example.myproject.model.StatusVisita.valueOf(dto.getStatus()) : null);
        // Visitante deve ser setado via service
        return entity;
    }

    public static VisitaDTO toDTO(Visita entity) {
        VisitaDTO dto = new VisitaDTO();
        dto.setId(entity.getId());
        dto.setDataVisita(entity.getEntrada()); // Ajuste conforme seu domínio
        dto.setStatus(entity.getStatus() != null ? entity.getStatus().name() : null);
        // Nome do visitante pode ser setado via service
        return dto;
    }
}
