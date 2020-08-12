package com.estacionamento.apirestestacionamento.models;
import javax.persistence.*;

@Entity
@Table(name="TB_CARRO")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable=false, unique = true)
    private String placa;

    @Column(nullable=false)
    private String marca;

    public Carro() {
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
