package com.example.myproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.myproject.dto.ReservaDTO;
import com.example.myproject.model.Reserva;
import com.example.myproject.model.StatusReserva;
import com.example.myproject.repository.ReservaRepository;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public void createReserva(ReservaDTO dto) {
        Reserva reserva = new Reserva();
        try {
            if (dto.getAreaAlugavelId() == null) {
                throw new IllegalArgumentException("Área alugável não pode ser nula");
            }
            if (dto.getMoradorId() == null) {
                throw new IllegalArgumentException("Morador não pode ser nulo");
            }
            if (dto.getDataInicio() == null) {
                throw new IllegalArgumentException("Data de início não pode ser nula");
            }
            if (dto.getDataFim() == null) {
                throw new IllegalArgumentException("Data de fim não pode ser nula");
            }
            if (dto.getDescricao() == null || dto.getDescricao().isEmpty()) {
                throw new IllegalArgumentException("Descrição não pode ser nula ou vazia");
            }
            if (dto.getStatusReserva() == null || dto.getStatusReserva().isEmpty()) {
                throw new IllegalArgumentException("Status da reserva não pode ser nulo ou vazio");
            }
            reserva.setAreaAlugavel(null); // Buscar AreaAlugavel por id se necessário
            reserva.setMorador(null); // Buscar Morador por id se necessário
            reserva.setAtiva(dto.isAtiva());
            reserva.setDataInicio(dto.getDataInicio());
            reserva.setDataFim(dto.getDataFim());
            reserva.setDescricao(dto.getDescricao());
            reserva.setStatusReserva(StatusReserva.valueOf(dto.getStatusReserva()));
            reservaRepository.save(reserva);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar reserva: " + e.getMessage(), e);
        }
    }

    public Reserva findById(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    public void updateReserva(ReservaDTO dto) {
        Reserva existing = findById(dto.getId());
        if (existing == null) {
            throw new IllegalArgumentException("Reserva não encontrada");
        }
        if (dto.getAreaAlugavelId() == null) {
            throw new IllegalArgumentException("Área alugável não pode ser nula");
        }
        if (dto.getMoradorId() == null) {
            throw new IllegalArgumentException("Morador não pode ser nulo");
        }
        if (dto.getDataInicio() == null) {
            throw new IllegalArgumentException("Data de início não pode ser nula");
        }
        if (dto.getDataFim() == null) {
            throw new IllegalArgumentException("Data de fim não pode ser nula");
        }
        if (dto.getDescricao() == null || dto.getDescricao().isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode ser nula ou vazia");
        }
        if (dto.getStatusReserva() == null || dto.getStatusReserva().isEmpty()) {
            throw new IllegalArgumentException("Status da reserva não pode ser nulo ou vazio");
        }
        try {
            existing.setAreaAlugavel(null); // Buscar AreaAlugavel por id se necessário
            existing.setMorador(null); // Buscar Morador por id se necessário
            existing.setAtiva(dto.isAtiva());
            existing.setDataInicio(dto.getDataInicio());
            existing.setDataFim(dto.getDataFim());
            existing.setDescricao(dto.getDescricao());
            existing.setStatusReserva(StatusReserva.valueOf(dto.getStatusReserva()));
            reservaRepository.save(existing);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar reserva: " + e.getMessage(), e);
        }
    }

    public void deleteReserva(Long id) {
        Reserva reserva = findById(id);
        if (reserva == null) {
            throw new IllegalArgumentException("Reserva não encontrada");
        }
        reservaRepository.delete(reserva);
    }
}
