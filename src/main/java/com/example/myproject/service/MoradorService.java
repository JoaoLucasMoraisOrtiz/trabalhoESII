package com.example.myproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.myproject.dto.AcessoDTO;
import com.example.myproject.dto.ContatoDTO;
import com.example.myproject.dto.MoradorDTO;
import com.example.myproject.dto.RawMoradorDTO;
import com.example.myproject.mapper.AcessoMapper;
import com.example.myproject.mapper.ContatoMapper;
import com.example.myproject.mapper.MoradorMapper;
import com.example.myproject.model.Acesso;
import com.example.myproject.model.Contato;
import com.example.myproject.model.Endereco;
import com.example.myproject.model.Morador;
import com.example.myproject.model.Unidade;
import com.example.myproject.repository.MoradorRepository;

// A anotação @Service indica que esta classe é um serviço
// e será gerenciada pelo Spring
@Service
public class MoradorService {
    private final MoradorRepository moradorRepository;
    private final UnidadeService unidadeService;
    private final EnderecoService enderecoService;
    


    //Construtor da classe
    public MoradorService(MoradorRepository moradorRepository, UnidadeService unidadeService, EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
        this.moradorRepository = moradorRepository;
        this.unidadeService = unidadeService;
    }

    public void createMorador(RawMoradorDTO dto) {
        try {
            // Usando mappers para criar os DTOs
            ContatoDTO contatoDTO = ContatoMapper.fromRawMoradorDTO(dto);
            AcessoDTO acessoDTO = AcessoMapper.fromRawMoradorDTO(dto);

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
            MoradorDTO moradorDTO = MoradorMapper.fromRawMoradorDTO(dto, unidadesDoMorador);
            Morador morador = MoradorMapper.fromDTO(moradorDTO, contato, acesso, enderecosDoMorador);

            moradorRepository.save(morador);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar morador: " + e.getMessage(), e);
        }
    }

    public Morador findById(long id) {
        return moradorRepository.findById(id).orElse(null);
    }

    public List<Morador> findAll() {
        return moradorRepository.findAll();
    }

    public void updateMorador(MoradorDTO dto) {
        
        // Verifica se o morador existe
        Morador morador = findById(dto.getIdMorador());
        if (morador == null) {
            throw new IllegalArgumentException("Morador não encontrado");
        }

        // Validação dos dados do DTO
        if (dto.getUnidade() == null || dto.getUnidade().isEmpty()) {
            throw new IllegalArgumentException("Unidade não pode ser nula ou vazia");
        } else if (dto.getTipoMorador() == null) {
            throw new IllegalArgumentException("Tipo de morador não pode ser nulo");
        } else if (dto.getNome() == null || dto.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        } else if (dto.getCpf() == null || dto.getCpf().isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio");
        } else if (dto.getDataNascimento() == null) {
            throw new IllegalArgumentException("Data de nascimento não pode ser nula");
        } else if (dto.getContato() == null) {
            throw new IllegalArgumentException("Contato não pode ser nulo");
        } else if (dto.getAcesso() == null) {
            throw new IllegalArgumentException("Acesso não pode ser nulo");
        } else if (dto.getEndereco() == null || dto.getEndereco().isEmpty()) {
            throw new IllegalArgumentException("Endereço não pode ser nulo ou vazio");
        }

        // Atualiza os dados do morador
        try {
            morador.setUnidade(dto.getUnidade());
            morador.setCobranca(dto.getCobranca());
            morador.setTipoMorador(dto.getTipoMorador());
            morador.setNome(dto.getNome());
            morador.setCpf(dto.getCpf());
            morador.setDataNascimento(dto.getDataNascimento());
            morador.setContato(dto.getContato());
            morador.setAcesso(dto.getAcesso());
            morador.setEndereco(dto.getEndereco());

            moradorRepository.save(morador);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar morador: " + e.getMessage(), e);
        }
    }

    public void deleteMorador(long id) {
        Morador morador = findById(id);
        if (morador == null) {
            throw new IllegalArgumentException("Morador não encontrado");
        }
        moradorRepository.delete(morador);
    }
}