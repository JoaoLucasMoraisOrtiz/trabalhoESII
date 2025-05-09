package com.example.myproject.mapper;

import java.util.List;

import com.example.myproject.dto.MoradorDTO;
import com.example.myproject.dto.RawMoradorDTO;
import com.example.myproject.model.Acesso;
import com.example.myproject.model.Contato;
import com.example.myproject.model.Endereco;
import com.example.myproject.model.Morador;
import com.example.myproject.model.TipoMorador;
import com.example.myproject.model.Unidade;

public class MoradorMapper {
    public static MoradorDTO fromRawMoradorDTO(RawMoradorDTO dto, List<Unidade> unidades) {
        MoradorDTO moradorDTO = new MoradorDTO();
        moradorDTO.setNome(dto.getNome());
        moradorDTO.setCpf(dto.getCpf());
        moradorDTO.setDataNascimento(dto.getDataNascimento());
        moradorDTO.setTipoMorador(TipoMorador.valueOf(dto.getTipoMorador()));
        moradorDTO.setUnidade(unidades);
        return moradorDTO;
    }

    public static Morador fromDTO(MoradorDTO dto, Contato contato, Acesso acesso, List<Endereco> enderecos) {
        Morador morador = new Morador();
        morador.setNome(dto.getNome());
        morador.setCpf(dto.getCpf());
        morador.setDataNascimento(dto.getDataNascimento());
        morador.setTipoMorador(dto.getTipoMorador());
        morador.setUnidade(dto.getUnidade());
        morador.setContato(contato);
        morador.setAcesso(acesso);
        morador.setEndereco(enderecos);
        return morador;
    }
}
