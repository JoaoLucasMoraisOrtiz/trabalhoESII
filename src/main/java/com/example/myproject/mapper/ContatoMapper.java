package com.example.myproject.mapper;

import com.example.myproject.dto.ContatoDTO;
import com.example.myproject.dto.RawMoradorDTO;
import com.example.myproject.dto.RawProprietarioDTO;
import com.example.myproject.model.Contato;

public class ContatoMapper {
    public static ContatoDTO fromRawMoradorDTO(RawMoradorDTO dto) {
        ContatoDTO contatoDTO = new ContatoDTO();
        contatoDTO.setEmail(dto.getEmail());
        contatoDTO.setCelular(dto.getCelular());
        contatoDTO.setTelefoneComercial(dto.getTelefoneComercial());
        contatoDTO.setTelefoneResidencial(dto.getTelefoneResidencial());
        return contatoDTO;
    }

    public static ContatoDTO fromRawProprietarioDTO(RawProprietarioDTO dto) {
        ContatoDTO contatoDTO = new ContatoDTO();
        contatoDTO.setEmail(dto.getEmail());
        contatoDTO.setCelular(dto.getCelular());
        contatoDTO.setTelefoneComercial(dto.getTelefoneComercial());
        contatoDTO.setTelefoneResidencial(dto.getTelefoneResidencial());
        return contatoDTO;
    }

    public static Contato fromDTO(ContatoDTO dto) {
        Contato contato = new Contato();
        contato.setEmail(dto.getEmail());
        contato.setCelular(dto.getCelular());
        contato.setTelefoneComercial(dto.getTelefoneComercial());
        contato.setTelefoneResidencial(dto.getTelefoneResidencial());
        return contato;
    }
}
