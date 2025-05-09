package com.example.myproject.mapper;

import com.example.myproject.dto.PagamentoDTO;
import com.example.myproject.model.Pagamento;

public class PagamentoMapper {
    public static Pagamento toEntity(PagamentoDTO dto) {
        Pagamento entity = new Pagamento();
        entity.setDataPagamento(dto.getDataPagamento());
        entity.setValorPago(dto.getValorPago());
        entity.setFormaPagamento(dto.getFormaPagamento());
        return entity;
    }

    public static PagamentoDTO toDTO(Pagamento entity) {
        PagamentoDTO dto = new PagamentoDTO();
        dto.setId(entity.getId());
        dto.setDataPagamento(entity.getDataPagamento());
        dto.setValorPago(entity.getValorPago());
        dto.setFormaPagamento(entity.getFormaPagamento());
        return dto;
    }
}
