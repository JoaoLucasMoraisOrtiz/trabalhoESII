package com.example.myproject.mapper;

import com.example.myproject.dto.PessoaDTO;
import com.example.myproject.model.Pessoa;

public class PessoaMapper {
    public static PessoaDTO toDTO(Pessoa entity) {
        PessoaDTO dto = new PessoaDTO();
        dto.setNome(entity.getNome());
        dto.setCpf(entity.getCpf());
        dto.setDataNascimento(entity.getDataNascimento());
        dto.setContato(entity.getContato());
        dto.setAcesso(entity.getAcesso());
        dto.setEndereco(entity.getEndereco());
        return dto;
    }
    // O método toEntity pode ser implementado conforme a necessidade do seu fluxo
}
