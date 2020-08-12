package com.estacionamento.apirestestacionamento.repository;

import com.estacionamento.apirestestacionamento.models.Estacionamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Long> {
}
