package com.estacionamento.apirestestacionamento.services;

import com.estacionamento.apirestestacionamento.models.Carro;
import com.estacionamento.apirestestacionamento.models.Ticket;
import com.estacionamento.apirestestacionamento.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public void create(Carro carro){
        Ticket ticket = new Ticket(carro);
        ticket.setData(Calendar.getInstance());

        ticketRepository.save(ticket);
    }
}
