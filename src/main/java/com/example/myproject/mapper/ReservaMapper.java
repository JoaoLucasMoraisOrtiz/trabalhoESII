package com.example.myproject.mapper;

import com.example.myproject.dto.ReservaDTO;
import com.example.myproject.model.Reserva;

public class ReservaMapper {
    public static Reserva toEntity(ReservaDTO dto) {
        Reserva entity = new Reserva();
        entity.setAtiva(dto.isAtiva());
        entity.setDataInicio(dto.getDataInicio());
        entity.setDataFim(dto.getDataFim());
        entity.setDescricao(dto.getDescricao());
        if (dto.getStatusReserva() != null) {
            entity.setStatusReserva(com.example.myproject.model.StatusReserva.valueOf(dto.getStatusReserva()));
        }
        // AreaAlugavel e Morador devem ser setados via service
        return entity;
    }

    public static ReservaDTO toDTO(Reserva entity) {
        ReservaDTO dto = new ReservaDTO();
        dto.setId(entity.getId());
        dto.setAtiva(entity.isAtiva());
        dto.setDataInicio(entity.getDataInicio());
        dto.setDataFim(entity.getDataFim());
        dto.setDescricao(entity.getDescricao());
        if (entity.getStatusReserva() != null) {
            dto.setStatusReserva(entity.getStatusReserva().name());
        }
        // AreaAlugavelId e MoradorId podem ser setados via service
        return dto;
    }
}
