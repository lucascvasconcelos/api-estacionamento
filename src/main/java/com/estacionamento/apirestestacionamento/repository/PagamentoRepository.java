package com.estacionamento.apirestestacionamento.repository;

import com.estacionamento.apirestestacionamento.models.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
