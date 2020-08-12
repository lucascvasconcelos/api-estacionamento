package com.estacionamento.apirestestacionamento.services;

import com.estacionamento.apirestestacionamento.models.Carro;
import com.estacionamento.apirestestacionamento.models.Vaga;
import com.estacionamento.apirestestacionamento.repository.CarroRepository;
import com.estacionamento.apirestestacionamento.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.lang.Exception;
import java.util.ArrayList;


//import java.util.logging.Logger;

@Service
public class VagaService {

    @Autowired
    VagaRepository vagaRepository;

    @Autowired
    CarroRepository carroRepository;

    public List<Vaga> listaVagas() {
        return vagaRepository.findAllByOrderByIdAsc();
    }
//    private Sort sortByIdAsc() {
//        return new Sort(Sort.Direction.ASC, "id");
//    }


    public Vaga estacionar(Long id, Carro carro) throws Exception {
        Vaga vaga = vagaRepository.getOne(id);

        if (vaga == null) {
            throw new Exception("Vaga não encontrada");
        }

        if (vaga.getCarro() != null) {

            throw new Exception("Vaga já possui carro estacionado");
        }

        vaga.setCarro(carro);
        vagaRepository.save(vaga);
        return vaga;
    }
}
