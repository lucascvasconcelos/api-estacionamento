package com.estacionamento.apirestestacionamento.services;

import com.estacionamento.apirestestacionamento.models.Carro;
import com.estacionamento.apirestestacionamento.repository.CarroRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.lang.Exception;

@Service
public class CarroService {

    @Autowired
    CarroRepository carroRepository;

    public List<Carro> listaCarros() {
        return carroRepository.findAll();
    }

//    A CRIAÇAO DO CARRO OCORRE NO MEMENTO DE ESTACIONAR QUANDO
//    É INFORMADO A PLACA E O MODELO DO CARRP QUE IRÁ OCUPAR A VAGA
    public Carro create(Carro carro) throws Exception {

        this.verificaCarrosEstacionados(carro.getPlaca());

        if (carro.getPlaca() == null) {
            throw new Exception("Necessário mais informções acerca do carro");
        }

        return carroRepository.save(carro);
    }

    public void verificaCarrosEstacionados(String placa) throws Exception {

        for (Carro carro : carroRepository.findAll()){
            if (carro.getPlaca().equals(placa)){
                throw new Exception("Carro já se encontra estacionado");
            }
        }
    }
}
