package com.estacionamento.apirestestacionamento.services;
import com.estacionamento.apirestestacionamento.models.Carro;
import com.estacionamento.apirestestacionamento.models.Pagamento;
import com.estacionamento.apirestestacionamento.models.Ticket;
import com.estacionamento.apirestestacionamento.models.Vaga;
import com.estacionamento.apirestestacionamento.repository.CarroRepository;
import com.estacionamento.apirestestacionamento.repository.PagamentoRepository;
import com.estacionamento.apirestestacionamento.repository.TicketRepository;
import com.estacionamento.apirestestacionamento.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class PagamentoService {

    final double VALOR_TRES_HORAS = 7.00;
    final double VALOR_HORA_EXTRA = 3.00;

    @Autowired
    CarroRepository carroRepository;

    @Autowired
    VagaRepository vagaRepository;

    @Autowired
    PagamentoRepository pagamentoRepository;

    @Autowired
    TicketRepository ticketRepository;

    public double processaTicker(Long id){
        Carro carro = carroRepository.getOne(id);
        Ticket ticket = ticketRepository.findTicketByCarro(carro);
        int horasEstacionado = this.calculaDiferencaDeDataEmHoras(ticket.getData());
        double valorTotal = this.calculaValorTotal(horasEstacionado);

        Vaga vaga = vagaRepository.findVagaByCarro(ticket.getCarro());
        vaga.setCarro(null);
        vagaRepository.save(vaga);

        Pagamento pagamento = new Pagamento(ticket);
        pagamento.setValorTotal(valorTotal);
        pagamentoRepository.save(pagamento);

        return valorTotal;
    }

    public void pagar(Long id){
        Pagamento pagamento = pagamentoRepository.getOne(id);
        pagamento.setRecebido(true);
        pagamentoRepository.save(pagamento);
    }

    public double calculaValorTotal(double horasEstacionado){
        double valorTotal = 0;

        if (horasEstacionado > VALOR_TRES_HORAS){
            valorTotal = (horasEstacionado - 3) * VALOR_HORA_EXTRA + VALOR_TRES_HORAS;
        }else {
            valorTotal = VALOR_TRES_HORAS;
        }

        return valorTotal;
    }

    public int calculaDiferencaDeDataEmHoras(Calendar data){
        int hora1 = data.get(Calendar.HOUR_OF_DAY);
        int hora2 = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        return hora2 - hora1;
    }
}
