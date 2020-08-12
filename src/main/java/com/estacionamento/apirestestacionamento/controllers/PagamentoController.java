package com.estacionamento.apirestestacionamento.controllers;

import com.estacionamento.apirestestacionamento.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class PagamentoController {

    @Autowired
    PagamentoService pagamentoService;

    @GetMapping("/pagamento/{id}")
    public ResponseEntity<String> pagar(@PathVariable Long id){
        pagamentoService.pagar(id);

        return new ResponseEntity<String>("TICKET PAGO!!", HttpStatus.OK);
    }

    @GetMapping("/gerar-valor/ticket/carro/{id}")
    public ResponseEntity<Double> processaTicket(@PathVariable Long id){
        Double valorTotal = pagamentoService.processaTicker(id);

        return new ResponseEntity<>(valorTotal, HttpStatus.CREATED);
    }
}
