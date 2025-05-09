package com.example.myproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.myproject.dto.CobrancaDTO;
import com.example.myproject.model.Cobranca;
import com.example.myproject.repository.CobrancaRepository;

@Service
public class CobrancaService {
    private final CobrancaRepository cobrancaRepository;

    public CobrancaService(CobrancaRepository cobrancaRepository) {
        this.cobrancaRepository = cobrancaRepository;
    }

    public void createCobranca(CobrancaDTO dto) {
        Cobranca cobranca = new Cobranca();
        try {
            if (dto.getValor() < 0) {
                throw new IllegalArgumentException("Valor deve ser maior ou igual à zero");
            }
            if (dto.getDataEmissao() == null) {
                throw new IllegalArgumentException("Data de emissão não pode ser nula");
            }
            if (dto.getDataVencimento() == null) {
                throw new IllegalArgumentException("Data de vencimento não pode ser nula");
            }
            if (dto.getStatus() == null || dto.getStatus().isEmpty()) {
                throw new IllegalArgumentException("Status não pode ser nulo ou vazio");
            }
            cobranca.setValor(dto.getValor());
            cobranca.setDataEmissao(dto.getDataEmissao());
            cobranca.setDataVencimento(dto.getDataVencimento());
            cobranca.setStatus(dto.getStatus());
            // Pagamento é opcional, mas se vier, pode ser buscado por id
            cobranca.setPagamento(null); // Implemente busca se necessário
            cobrancaRepository.save(cobranca);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar cobrança: " + e.getMessage(), e);
        }
    }

    public Cobranca findById(Long id) {
        return cobrancaRepository.findById(id).orElse(null);
    }

    public List<Cobranca> findAll() {
        return cobrancaRepository.findAll();
    }

    public void updateCobranca(CobrancaDTO dto) {
        Cobranca existing = findById(dto.getId());
        if (existing == null) {
            throw new IllegalArgumentException("Cobrança não encontrada");
        }
        // Validação dos dados do DTO
        if (dto.getValor() <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero");
        }
        if (dto.getDataEmissao() == null) {
            throw new IllegalArgumentException("Data de emissão não pode ser nula");
        }
        if (dto.getDataVencimento() == null) {
            throw new IllegalArgumentException("Data de vencimento não pode ser nula");
        }
        if (dto.getStatus() == null || dto.getStatus().isEmpty()) {
            throw new IllegalArgumentException("Status não pode ser nulo ou vazio");
        }
        try {
            existing.setValor(dto.getValor());
            existing.setDataEmissao(dto.getDataEmissao());
            existing.setDataVencimento(dto.getDataVencimento());
            existing.setStatus(dto.getStatus());
            // Pagamento é opcional, mas se vier, pode ser buscado por id
            existing.setPagamento(null); // Implemente busca se necessário
            cobrancaRepository.save(existing);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar cobrança: " + e.getMessage(), e);
        }
    }

    public void deleteCobranca(Long id) {
        Cobranca cobranca = findById(id);
        if (cobranca == null) {
            throw new IllegalArgumentException("Cobrança não encontrada");
        }
        cobrancaRepository.delete(cobranca);
    }
}
