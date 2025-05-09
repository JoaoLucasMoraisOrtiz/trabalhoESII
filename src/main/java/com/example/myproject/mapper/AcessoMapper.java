package com.example.myproject.mapper;

import com.example.myproject.dto.AcessoDTO;
import com.example.myproject.dto.RawMoradorDTO;
import com.example.myproject.dto.RawProprietarioDTO;
import com.example.myproject.model.Acesso;
import com.example.myproject.model.UserRole;

public class AcessoMapper {
    public static AcessoDTO fromRawMoradorDTO(RawMoradorDTO dto) {
        AcessoDTO acessoDTO = new AcessoDTO();
        acessoDTO.setUsuario(dto.getUsuario());
        acessoDTO.setSenha(dto.getSenha());
        acessoDTO.setUserRole(UserRole.MORADOR); // ou ajuste conforme necessário
        return acessoDTO;
    }

    public static AcessoDTO fromRawProprietarioDTO(RawProprietarioDTO dto) {
        AcessoDTO acessoDTO = new AcessoDTO();
        acessoDTO.setUsuario(dto.getUsuario());
        acessoDTO.setSenha(dto.getSenha());
        acessoDTO.setUserRole(UserRole.MORADOR); // ou ajuste conforme necessário
        return acessoDTO;
    }

    public static Acesso fromDTO(AcessoDTO dto) {
        Acesso acesso = new Acesso();
        acesso.setUsuario(dto.getUsuario());
        acesso.setSenha(dto.getSenha());
        acesso.setUserRole(dto.getUserRole());
        return acesso;
    }
}
