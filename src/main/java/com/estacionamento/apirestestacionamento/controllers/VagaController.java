package com.estacionamento.apirestestacionamento.controllers;

import com.estacionamento.apirestestacionamento.models.Carro;
import com.estacionamento.apirestestacionamento.models.Vaga;
import com.estacionamento.apirestestacionamento.services.CarroService;
import com.estacionamento.apirestestacionamento.services.TicketService;
import com.estacionamento.apirestestacionamento.services.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.lang.Exception;

@RestController
@RequestMapping(value = "/api")
public class VagaController {

    @Autowired
    VagaService vagaService;

    @Autowired
    CarroService carroService;

    @Autowired
    TicketService ticketService;

    @GetMapping("/vagas")
    public ResponseEntity<List<Vaga>> listaCarros() {
        List<Vaga> vagas = vagaService.listaVagas();

        return new ResponseEntity<List<Vaga>>(vagas, HttpStatus.OK);
    }

    //A CRIAÇAO DO CARRO OCORRE NO MEMENTO DE ESTACIONAR QUANDO
    //É INFORMADO A PLACA E O MODELO DO CARRO QUE IRÁ OCUPAR A VAGA
    @PostMapping("/estacionar/{id}")
    public ResponseEntity<String> create(@PathVariable Long id, @RequestBody Carro carroRequest) {
        try {
            Carro carro = carroService.create(carroRequest);
            vagaService.estacionar(id, carro);
            ticketService.create(carro);

            return new ResponseEntity<String>("{ msg: 'Carro Estacionado!!' }", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }
}
