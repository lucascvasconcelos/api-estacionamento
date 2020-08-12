package com.estacionamento.apirestestacionamento.controllers;

import com.estacionamento.apirestestacionamento.models.Relatorio;
import com.estacionamento.apirestestacionamento.services.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class RelatorioController {

    @Autowired
    RelatorioService relatorioService;

    @PostMapping("/relatorio")
    public ResponseEntity<Relatorio> create() {
        relatorioService.gerarRelatorio();

        Relatorio relatorio = relatorioService.listRelatorio();

        return new ResponseEntity<>(relatorio, HttpStatus.CREATED);
    }
}
