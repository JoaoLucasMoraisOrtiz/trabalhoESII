package com.example.myproject.mapper;

import com.example.myproject.dto.FuncionarioDTO;
import com.example.myproject.model.Funcionario;

public class FuncionarioMapper {
    public static Funcionario toEntity(FuncionarioDTO dto) {
        Funcionario entity = new Funcionario();
        // Adicione campos específicos de FuncionarioDTO aqui
        return entity;
    }

    public static FuncionarioDTO toDTO(Funcionario entity) {
        FuncionarioDTO dto = new FuncionarioDTO();
        // Adicione campos específicos de Funcionario aqui
        return dto;
    }
}
