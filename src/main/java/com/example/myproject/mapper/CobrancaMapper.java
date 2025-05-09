package com.example.myproject.mapper;

import com.example.myproject.dto.CobrancaDTO;
import com.example.myproject.model.Cobranca;

public class CobrancaMapper {
    public static Cobranca toEntity(CobrancaDTO dto) {
        Cobranca entity = new Cobranca();
        entity.setValor(dto.getValor());
        entity.setDataEmissao(dto.getDataEmissao());
        entity.setDataVencimento(dto.getDataVencimento());
        entity.setStatus(dto.getStatus());
        // Pagamento deve ser setado via service
        return entity;
    }

    public static CobrancaDTO toDTO(Cobranca entity) {
        CobrancaDTO dto = new CobrancaDTO();
        dto.setId(entity.getId());
        dto.setValor(entity.getValor());
        dto.setDataEmissao(entity.getDataEmissao());
        dto.setDataVencimento(entity.getDataVencimento());
        dto.setStatus(entity.getStatus());
        // PagamentoId pode ser setado via service
        return dto;
    }
}
