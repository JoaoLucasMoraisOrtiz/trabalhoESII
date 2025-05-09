package com.example.myproject.service;

import com.example.myproject.dto.UnidadeDTO;
import com.example.myproject.model.Unidade;
import com.example.myproject.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeService {
    private final UnidadeRepository unidadeRepository;

    public UnidadeService(UnidadeRepository unidadeRepository) {
        this.unidadeRepository = unidadeRepository;
    }

    public Unidade createUnidade(UnidadeDTO dto) {
        validarUnidade(dto);
        Unidade unidade = new Unidade();
        unidade.setLocalizacao(dto.getLocalizacao());
        unidade.setTamanhoM2(dto.getTamanhoM2());
        return unidadeRepository.save(unidade);
    }

    public Unidade findById(Long id) {
        return unidadeRepository.findById(id).orElse(null);
    }

    public List<Unidade> findAll() {
        return unidadeRepository.findAll();
    }

    public void updateUnidade(UnidadeDTO dto) {
        Unidade unidade = findById(dto.getIdUnidade());
        if (unidade == null) {
            throw new IllegalArgumentException("Unidade não encontrada");
        }
        validarUnidade(dto);
        unidade.setLocalizacao(dto.getLocalizacao());
        unidade.setTamanhoM2(dto.getTamanhoM2());
        unidadeRepository.save(unidade);
    }

    public void deleteUnidade(Long id) {
        Unidade unidade = findById(id);
        if (unidade == null) {
            throw new IllegalArgumentException("Unidade não encontrada");
        }
        unidadeRepository.delete(unidade);
    }

    private void validarUnidade(UnidadeDTO dto) {
        if (dto.getLocalizacao() == null || dto.getLocalizacao().isEmpty()) {
            throw new IllegalArgumentException("Localização não pode ser nula ou vazia");
        }
        if (dto.getTamanhoM2() <= 0) {
            throw new IllegalArgumentException("Tamanho deve ser maior que zero");
        }
    }
}
