package com.example.myproject.service;

import java.util.ArrayList;
import java.util.List;

import com.example.myproject.dto.AcessoDTO;
import com.example.myproject.dto.ContatoDTO;
import com.example.myproject.dto.ProprietarioDTO;
import com.example.myproject.dto.RawProprietarioDTO;
import com.example.myproject.mapper.AcessoMapper;
import com.example.myproject.mapper.ContatoMapper;
import com.example.myproject.mapper.ProprietarioMapper;
import com.example.myproject.model.Acesso;
import com.example.myproject.model.Contato;
import com.example.myproject.model.Endereco;
import com.example.myproject.model.Proprietario;
import com.example.myproject.model.Unidade;
import com.example.myproject.repository.ProprietarioRepository;

public class ProprietarioService {

    private final ProprietarioRepository proprietarioRepository;
    private final UnidadeService unidadeService;
    private final EnderecoService enderecoService;

    //Construtor da classe
    public ProprietarioService(ProprietarioRepository proprietarioRepository, UnidadeService unidadeService, EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
        this.proprietarioRepository = proprietarioRepository;
        this.unidadeService = unidadeService;
    }


    public void createMorador(RawProprietarioDTO dto) {
        try {
            // Usando mappers para criar os DTOs
            ContatoDTO contatoDTO = ContatoMapper.fromRawProprietarioDTO(dto);
            AcessoDTO acessoDTO = AcessoMapper.fromRawProprietarioDTO(dto);

            Contato contato = ContatoMapper.fromDTO(contatoDTO);
            Acesso acesso = AcessoMapper.fromDTO(acessoDTO);

            // Buscar unidades existentes
            List<Unidade> unidadesDoMorador = new ArrayList<>();
            for (Long item : dto.getUnidadeId()) {
                Unidade unidade = unidadeService.findById(item);
                if (unidade == null) {
                    throw new IllegalArgumentException("Unidade não encontrada com o ID: " + item);
                }
                unidadesDoMorador.add(unidade);
            }
            
            List<Endereco> enderecosDoMorador = new ArrayList<>();
            for(Long item : dto.getEnderecoId()) {
                Endereco endereco = enderecoService.findById(item);
                if (endereco == null) {
                    throw new IllegalArgumentException("Endereço não encontrado com o ID: " + item);
                }
                enderecosDoMorador.add(endereco);
            }

            // Usando mapper para criar MoradorDTO
            ProprietarioDTO proprietarioDTO = ProprietarioMapper.RawProprietarioDTO(dto);
            Proprietario morador = ProprietarioMapper.fromDTO(proprietarioDTO, contato, acesso, enderecosDoMorador);

            proprietarioRepository.save(morador);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar morador: " + e.getMessage(), e);
        }
    }
}
