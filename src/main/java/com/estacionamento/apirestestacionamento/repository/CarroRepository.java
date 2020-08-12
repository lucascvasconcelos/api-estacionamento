package com.estacionamento.apirestestacionamento.repository;

import com.estacionamento.apirestestacionamento.models.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long>
{

}
