package com.example.myproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.myproject.dto.AcessoDTO;
import com.example.myproject.model.Acesso;
import com.example.myproject.repository.AcessoRepository;

@Service
public class AcessoService {
    private final AcessoRepository acessoRepository;

    public AcessoService(AcessoRepository acessoRepository) {
        this.acessoRepository = acessoRepository;
    }

    public Acesso createAcesso(AcessoDTO dto) {
        validarAcesso(dto);
        // Verifica se já existe um usuário com o mesmo nome de usuário
        if (acessoRepository.findAll().stream().anyMatch(a -> a.getUsuario().equals(dto.getUsuario()))) {
            throw new IllegalArgumentException("Já existe um acesso com este usuário");
        }
        Acesso acesso = new Acesso();
        acesso.setUsuario(dto.getUsuario());
        acesso.setSenha(dto.getSenha());
        acesso.setUserRole(dto.getUserRole());
        return acessoRepository.save(acesso);
    }

    public Acesso findById(Long id) {
        return acessoRepository.findById(id).orElse(null);
    }

    public List<Acesso> findAll() {
        return acessoRepository.findAll();
    }

    public void updateAcesso(AcessoDTO dto) {
        Acesso acesso = findById(dto.getId());
        if (acesso == null) {
            throw new IllegalArgumentException("Acesso não encontrado");
        }
        validarAcesso(dto);
        // Verifica se já existe outro usuário com o mesmo nome de usuário
        if (acessoRepository.findAll().stream().anyMatch(a -> !a.getId().equals(dto.getId()) && a.getUsuario().equals(dto.getUsuario()))) {
            throw new IllegalArgumentException("Já existe outro acesso com este usuário");
        }
        acesso.setUsuario(dto.getUsuario());
        acesso.setSenha(dto.getSenha());
        acesso.setUserRole(dto.getUserRole());
        acessoRepository.save(acesso);
    }

    public void deleteAcesso(Long id) {
        Acesso acesso = findById(id);
        if (acesso == null) {
            throw new IllegalArgumentException("Acesso não encontrado");
        }
        acessoRepository.delete(acesso);
    }

    private void validarAcesso(AcessoDTO dto) {
        if (dto.getUsuario() == null || dto.getUsuario().isEmpty()) {
            throw new IllegalArgumentException("Usuário não pode ser nulo ou vazio");
        }
        if (dto.getSenha() == null || dto.getSenha().isEmpty()) {
            throw new IllegalArgumentException("Senha não pode ser nula ou vazia");
        }
        if (dto.getUserRole() == null) {
            throw new IllegalArgumentException("UserRole não pode ser nulo");
        }
    }
}
