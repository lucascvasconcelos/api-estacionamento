package com.estacionamento.apirestestacionamento.repository;

import com.estacionamento.apirestestacionamento.models.Carro;
import com.estacionamento.apirestestacionamento.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    public Ticket findTicketByCarro(Carro carro);
}
