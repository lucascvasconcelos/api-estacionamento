package com.estacionamento.apirestestacionamento.services;

import com.estacionamento.apirestestacionamento.models.Pagamento;
import com.estacionamento.apirestestacionamento.models.Relatorio;
import com.estacionamento.apirestestacionamento.repository.PagamentoRepository;
import com.estacionamento.apirestestacionamento.repository.CarroRepository;
import com.estacionamento.apirestestacionamento.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    CarroRepository carroRepository;

    @Autowired
    PagamentoRepository pagamentoRepository;

    @Autowired
    RelatorioRepository relatorioRepository;

    public void gerarRelatorio(){
        int qtdCarrosEstacionados = carroRepository.findAll().size();
        double valorTotalFaturamento = this.calcularFaturamento(pagamentoRepository.findAll());

        Relatorio relatorio = new Relatorio(qtdCarrosEstacionados,valorTotalFaturamento);
        relatorioRepository.save(relatorio);
    }

    public double calcularFaturamento(List<Pagamento> pagamentos){
        double total = 0;

        for (Pagamento pagamento: pagamentos){
            total += pagamento.getValorTotal();
        }

        return total;
    }

    public Relatorio listRelatorio(){
        return relatorioRepository.findAll().get(0);
    }
}
