package com.estacionamento.apirestestacionamento.repository;

import com.estacionamento.apirestestacionamento.models.Carro;
import com.estacionamento.apirestestacionamento.models.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VagaRepository extends JpaRepository<Vaga, Long> {

//    Vaga findBYCarro(Carro carro);
        public List<Vaga> findAllByOrderByIdAsc();
        public Vaga findVagaByCarro(Carro carro);
}
