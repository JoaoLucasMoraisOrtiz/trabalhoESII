package com.example.myproject.mapper;

import com.example.myproject.dto.AutorizacaoDTO;
import com.example.myproject.model.Autorizacao;

public class AutorizacaoMapper {
    public static Autorizacao toEntity(AutorizacaoDTO dto) {
        Autorizacao entity = new Autorizacao();
        entity.setIdVisitaAgendada(dto.getIdVisitaAgendada());
        entity.setDataHoraAutorizacao(dto.getDataHoraAutorizacao());
        entity.setStatus(dto.getStatus() != null ? com.example.myproject.model.StatusAutorizacao.valueOf(dto.getStatus()) : null);
        // Morador e Visita devem ser setados via service
        return entity;
    }

    public static AutorizacaoDTO toDTO(Autorizacao entity) {
        AutorizacaoDTO dto = new AutorizacaoDTO();
        dto.setId(entity.getId());
        dto.setIdVisitaAgendada(entity.getIdVisitaAgendada());
        dto.setDataHoraAutorizacao(entity.getDataHoraAutorizacao());
        dto.setStatus(entity.getStatus() != null ? entity.getStatus().name() : null);
        // MoradorId e VisitaId podem ser setados via service
        return dto;
    }
}
