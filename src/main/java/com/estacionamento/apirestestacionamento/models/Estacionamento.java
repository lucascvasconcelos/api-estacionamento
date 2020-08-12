package com.estacionamento.apirestestacionamento.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_ESTACIONAMENTO")
public class Estacionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "estacionamento", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Vaga> vagas = new ArrayList<>();

    public Estacionamento(){
    }

    public List<Vaga> getVagas() {
        return vagas;
    }
}
