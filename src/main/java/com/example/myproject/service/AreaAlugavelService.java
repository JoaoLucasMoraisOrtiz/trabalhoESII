package com.example.myproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.myproject.dto.AreaAlugavelDTO;
import com.example.myproject.model.AreaAlugavel;
import com.example.myproject.repository.AreaAlugavelRepository;

@Service
public class AreaAlugavelService {
    private final AreaAlugavelRepository areaAlugavelRepository;

    public AreaAlugavelService(AreaAlugavelRepository areaAlugavelRepository) {
        this.areaAlugavelRepository = areaAlugavelRepository;
    }

    public void createAreaAlugavel(AreaAlugavelDTO dto) {
        AreaAlugavel area = new AreaAlugavel();
        try {
            if (dto.getLimitePessoas() == null || dto.getLimitePessoas() <= 0) {
                throw new IllegalArgumentException("Limite de pessoas deve ser maior que zero");
            }
            if (dto.getDisponivelDe() == null) {
                throw new IllegalArgumentException("Data de início de disponibilidade não pode ser nula");
            }
            if (dto.getDisponivelAte() == null) {
                throw new IllegalArgumentException("Data de fim de disponibilidade não pode ser nula");
            }
            area.setLimitePessoas(dto.getLimitePessoas());
            area.setDisponivel(dto.isDisponivel());
            area.setDisponivelDe(dto.getDisponivelDe());
            area.setDisponivelAte(dto.getDisponivelAte());
            areaAlugavelRepository.save(area);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar área alugável: " + e.getMessage(), e);
        }
    }

    public AreaAlugavel findById(Long id) {
        return areaAlugavelRepository.findById(id).orElse(null);
    }

    public List<AreaAlugavel> findAll() {
        return areaAlugavelRepository.findAll();
    }

    public void updateAreaAlugavel(AreaAlugavelDTO dto) {
        AreaAlugavel existing = findById(dto.getId());
        if (existing == null) {
            throw new IllegalArgumentException("Área alugável não encontrada");
        }
        if (dto.getLimitePessoas() == null || dto.getLimitePessoas() <= 0) {
            throw new IllegalArgumentException("Limite de pessoas deve ser maior que zero");
        }
        if (dto.getDisponivelDe() == null) {
            throw new IllegalArgumentException("Data de início de disponibilidade não pode ser nula");
        }
        if (dto.getDisponivelAte() == null) {
            throw new IllegalArgumentException("Data de fim de disponibilidade não pode ser nula");
        }
        try {
            existing.setLimitePessoas(dto.getLimitePessoas());
            existing.setDisponivel(dto.isDisponivel());
            existing.setDisponivelDe(dto.getDisponivelDe());
            existing.setDisponivelAte(dto.getDisponivelAte());
            areaAlugavelRepository.save(existing);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar área alugável: " + e.getMessage(), e);
        }
    }

    public void deleteAreaAlugavel(Long id) {
        AreaAlugavel areaAlugavel = findById(id);
        if (areaAlugavel == null) {
            throw new IllegalArgumentException("Área alugável não encontrada");
        }
        areaAlugavelRepository.delete(areaAlugavel);
    }
}
