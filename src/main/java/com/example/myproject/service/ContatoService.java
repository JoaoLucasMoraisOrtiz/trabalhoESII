package com.example.myproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.myproject.dto.ContatoDTO;
import com.example.myproject.model.Contato;
import com.example.myproject.repository.ContatoRepository;

@Service
public class ContatoService {
    private final ContatoRepository contatoRepository;

    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    public Contato createContato(ContatoDTO dto) {
        validarContato(dto);
        Contato contato = new Contato();
        contato.setTelefoneResidencial(dto.getTelefoneResidencial());
        contato.setTelefoneComercial(dto.getTelefoneComercial());
        contato.setCelular(dto.getCelular());
        contato.setEmail(dto.getEmail());
        return contatoRepository.save(contato);
    }

    public Contato findById(Long id) {
        return contatoRepository.findById(id).orElse(null);
    }

    public List<Contato> findAll() {
        return contatoRepository.findAll();
    }

    public void updateContato(ContatoDTO dto) {
        Contato contato = findById(dto.getId());
        if (contato == null) {
            throw new IllegalArgumentException("Contato não encontrado");
        }
        validarContato(dto);
        contato.setTelefoneResidencial(dto.getTelefoneResidencial());
        contato.setTelefoneComercial(dto.getTelefoneComercial());
        contato.setCelular(dto.getCelular());
        contato.setEmail(dto.getEmail());
        contatoRepository.save(contato);
    }

    public void deleteContato(Long id) {
        Contato contato = findById(id);
        if (contato == null) {
            throw new IllegalArgumentException("Contato não encontrado");
        }
        contatoRepository.delete(contato);
    }

    private void validarContato(ContatoDTO dto) {
        if (dto.getCelular() == null || dto.getCelular().isEmpty()) {
            throw new IllegalArgumentException("Celular não pode ser nulo ou vazio");
        }
        if (dto.getEmail() == null || dto.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser nulo ou vazio");
        }
        // Telefones residenciais e comerciais são opcionais, mas você pode adicionar validações se necessário
    }
}