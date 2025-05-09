package com.example.myproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.myproject.dto.AutorizacaoDTO;
import com.example.myproject.model.Autorizacao;
import com.example.myproject.model.StatusAutorizacao;
import com.example.myproject.repository.AutorizacaoRepository;

@Service
public class AutorizacaoService {
    private final AutorizacaoRepository autorizacaoRepository;

    public AutorizacaoService(AutorizacaoRepository autorizacaoRepository) {
        this.autorizacaoRepository = autorizacaoRepository;
    }

    public void createAutorizacao(AutorizacaoDTO dto) {
        Autorizacao autorizacao = new Autorizacao();
        try {
            if (dto.getMoradorId() == null) {
                throw new IllegalArgumentException("Morador não pode ser nulo");
            }
            if (dto.getVisitaId() == null) {
                throw new IllegalArgumentException("Visita não pode ser nula");
            }
            if (dto.getDataHoraAutorizacao() == null) {
                throw new IllegalArgumentException("Data da autorização não pode ser nula");
            }
            if (dto.getStatus() == null || dto.getStatus().isEmpty()) {
                throw new IllegalArgumentException("Status não pode ser nulo ou vazio");
            }
            autorizacao.setMorador(null); // Buscar Morador por id se necessário
            autorizacao.setVisita(null); // Buscar Visita por id se necessário
            autorizacao.setDataHoraAutorizacao(dto.getDataHoraAutorizacao());
            autorizacao.setIdVisitaAgendada(dto.getIdVisitaAgendada());
            autorizacao.setStatus(StatusAutorizacao.valueOf(dto.getStatus()));
            autorizacaoRepository.save(autorizacao);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar autorização: " + e.getMessage(), e);
        }
    }

    public Autorizacao findById(Long id) {
        return autorizacaoRepository.findById(id).orElse(null);
    }

    public List<Autorizacao> findAll() {
        return autorizacaoRepository.findAll();
    }

    public void updateAutorizacao(AutorizacaoDTO dto) {
        Autorizacao existing = findById(dto.getId());
        if (existing == null) {
            throw new IllegalArgumentException("Autorização não encontrada");
        }
        if (dto.getMoradorId() == null) {
            throw new IllegalArgumentException("Morador não pode ser nulo");
        }
        if (dto.getVisitaId() == null) {
            throw new IllegalArgumentException("Visita não pode ser nula");
        }
        if (dto.getDataHoraAutorizacao() == null) {
            throw new IllegalArgumentException("Data da autorização não pode ser nula");
        }
        if (dto.getStatus() == null || dto.getStatus().isEmpty()) {
            throw new IllegalArgumentException("Status não pode ser nulo ou vazio");
        }
        try {
            existing.setMorador(null); // Buscar Morador por id se necessário
            existing.setVisita(null); // Buscar Visita por id se necessário
            existing.setDataHoraAutorizacao(dto.getDataHoraAutorizacao());
            existing.setIdVisitaAgendada(dto.getIdVisitaAgendada());
            existing.setStatus(StatusAutorizacao.valueOf(dto.getStatus()));
            autorizacaoRepository.save(existing);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar autorização: " + e.getMessage(), e);
        }
    }

    public void deleteAutorizacao(Long id) {
        Autorizacao autorizacao = findById(id);
        if (autorizacao == null) {
            throw new IllegalArgumentException("Autorização não encontrada");
        }
        autorizacaoRepository.delete(autorizacao);
    }
}
