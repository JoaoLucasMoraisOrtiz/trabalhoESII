package com.example.myproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.myproject.dto.VisitaDTO;
import com.example.myproject.model.StatusVisita;
import com.example.myproject.model.Visita;
import com.example.myproject.repository.VisitaRepository;

@Service
public class VisitaService {
    private final VisitaRepository visitaRepository;

    public VisitaService(VisitaRepository visitaRepository) {
        this.visitaRepository = visitaRepository;
    }

    public void createVisita(VisitaDTO dto) {
        Visita visita = new Visita();
        try {
            if (dto.getNomeVisitante() == null || dto.getNomeVisitante().isEmpty()) {
                throw new IllegalArgumentException("Nome do visitante não pode ser nulo ou vazio");
            }
            if (dto.getDataVisita() == null) {
                throw new IllegalArgumentException("Data da visita não pode ser nula");
            }
            if (dto.getStatus() == null || dto.getStatus().isEmpty()) {
                throw new IllegalArgumentException("Status não pode ser nulo ou vazio");
            }
            visita.setVisitante(null); // Buscar Visitante por nome/id se necessário
            visita.setEntrada(dto.getDataVisita());
            visita.setStatus(StatusVisita.valueOf(dto.getStatus()));
            visitaRepository.save(visita);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar visita: " + e.getMessage(), e);
        }
    }

    public Visita findById(Long id) {
        return visitaRepository.findById(id).orElse(null);
    }

    public List<Visita> findAll() {
        return visitaRepository.findAll();
    }

    public void updateVisita(VisitaDTO dto) {
        Visita existing = findById(dto.getId());
        if (existing == null) {
            throw new IllegalArgumentException("Visita não encontrada");
        }
        if (dto.getNomeVisitante() == null || dto.getNomeVisitante().isEmpty()) {
            throw new IllegalArgumentException("Nome do visitante não pode ser nulo ou vazio");
        }
        if (dto.getDataVisita() == null) {
            throw new IllegalArgumentException("Data da visita não pode ser nula");
        }
        if (dto.getStatus() == null || dto.getStatus().isEmpty()) {
            throw new IllegalArgumentException("Status não pode ser nulo ou vazio");
        }
        try {
            existing.setVisitante(null); // Buscar Visitante por nome/id se necessário
            existing.setEntrada(dto.getDataVisita());
            existing.setStatus(StatusVisita.valueOf(dto.getStatus()));
            visitaRepository.save(existing);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar visita: " + e.getMessage(), e);
        }
    }

    public void deleteVisita(Long id) {
        Visita visita = findById(id);
        if (visita == null) {
            throw new IllegalArgumentException("Visita não encontrada");
        }
        visitaRepository.delete(visita);
    }
}
