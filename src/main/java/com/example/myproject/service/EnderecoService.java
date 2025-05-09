package com.example.myproject.service;

import com.example.myproject.dto.EnderecoDTO;
import com.example.myproject.mapper.EnderecoMapper;
import com.example.myproject.model.Endereco;
import com.example.myproject.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco createEndereco(EnderecoDTO dto) {
        Endereco endereco = EnderecoMapper.fromDTO(dto);
        return enderecoRepository.save(endereco);
    }

    public Endereco findById(Long id) {
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        return endereco.orElse(null);
    }

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Endereco updateEndereco(Long id, Endereco updated) {
        Endereco endereco = findById(id);
        if (endereco == null) {
            throw new IllegalArgumentException("Endereço não encontrado");
        }
        endereco.setRua(updated.getRua());
        endereco.setNumero(updated.getNumero());
        endereco.setBairro(updated.getBairro());
        endereco.setCidade(updated.getCidade());
        endereco.setEstado(updated.getEstado());
        endereco.setCep(updated.getCep());
        return enderecoRepository.save(endereco);
    }

    public void deleteEndereco(Long id) {
        Endereco endereco = findById(id);
        if (endereco == null) {
            throw new IllegalArgumentException("Endereço não encontrado");
        }
        enderecoRepository.delete(endereco);
    }
}
