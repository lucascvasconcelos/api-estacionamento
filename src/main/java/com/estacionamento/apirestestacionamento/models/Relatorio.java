package com.estacionamento.apirestestacionamento.models;

import javax.persistence.*;

@Entity
@Table(name = "TB_RELATORIO")
public class Relatorio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int qtdVeiculo;

    private double valorFaturamento;

    public Relatorio() {
    }

    public Relatorio(int qtdVeiculo, double valorFaturamento) {
        this.qtdVeiculo = qtdVeiculo;
        this.valorFaturamento = valorFaturamento;
    }

    public int getQtdVeiculo() {
        return qtdVeiculo;
    }

    public void setQtdVeiculo(int qtdVeiculo) {
        this.qtdVeiculo = qtdVeiculo;
    }

    public double getValorFaturamento() {
        return valorFaturamento;
    }

    public void setValorFaturamento(double valorFaturamento) {
        this.valorFaturamento = valorFaturamento;
    }
}
