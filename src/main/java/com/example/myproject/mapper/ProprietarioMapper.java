package com.example.myproject.mapper;

import java.util.List;

import com.example.myproject.dto.ProprietarioDTO;
import com.example.myproject.dto.RawProprietarioDTO;
import com.example.myproject.model.Acesso;
import com.example.myproject.model.Contato;
import com.example.myproject.model.Endereco;
import com.example.myproject.model.Proprietario;

public class ProprietarioMapper {
    public static ProprietarioDTO RawProprietarioDTO(RawProprietarioDTO dto) {
        ProprietarioDTO entity = new ProprietarioDTO();
        
        entity.setId(dto.getId());
        
        if (dto.getNome() != null) {
            entity.setNome(dto.getNome());
        }
        if (dto.getCpf() != null) {
            entity.setCpf(dto.getCpf());
        }
        if (dto.getEndereco() != null) {
            entity.setEndereco(dto.getEndereco());
        }
        if (dto.getDataNascimento() != null) {
            entity.setDataNascimento(dto.getDataNascimento());
        }

        return entity;
    }

    public static Proprietario fromDTO(ProprietarioDTO dto, Contato contato, Acesso acesso, List<Endereco> enderecos) {
        Proprietario entity = new Proprietario();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setEndereco(dto.getEndereco());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setContato(contato);
        entity.setAcesso(acesso);
        entity.setEndereco(enderecos);
        return entity;
    }

    public static RawProprietarioDTO toDTO(Proprietario entity) {
        RawProprietarioDTO dto = new RawProprietarioDTO();
        // Adicione campos específicos de Proprietario aqui
        return dto;
    }

}
