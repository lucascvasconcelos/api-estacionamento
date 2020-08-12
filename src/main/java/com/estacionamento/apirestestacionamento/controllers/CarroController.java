package com.estacionamento.apirestestacionamento.controllers;
import com.estacionamento.apirestestacionamento.models.Carro;
import com.estacionamento.apirestestacionamento.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.lang.Exception;

@RestController
@RequestMapping(value = "/api")
public class CarroController {

    @Autowired
    CarroService carroService;

    @GetMapping("/carros")
    public ResponseEntity<List<Carro>> listaCarros() {
        List<Carro> carros = carroService.listaCarros();

        return new ResponseEntity<List<Carro>>(carros, HttpStatus.OK);
    }


    @PostMapping("/carro")
    public ResponseEntity<String> create(@RequestBody Carro carro) {
        try {
            carroService.create(carro);

            return new ResponseEntity<String>("Created", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }
}
