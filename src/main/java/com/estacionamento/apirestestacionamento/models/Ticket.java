package com.estacionamento.apirestestacionamento.models;

import javax.persistence.*;
import java.util.Calendar;


@Entity
@Table(name = "TB_TICKEt")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Calendar data;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carro_id", referencedColumnName = "id")
    private Carro carro;

    public Ticket(){
    }

    public Ticket(Carro carro){
        this.carro = carro;
        this.data = Calendar.getInstance();
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
