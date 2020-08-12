package com.estacionamento.apirestestacionamento.repository;

import com.estacionamento.apirestestacionamento.models.Relatorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelatorioRepository extends JpaRepository<Relatorio, Long> {
}
