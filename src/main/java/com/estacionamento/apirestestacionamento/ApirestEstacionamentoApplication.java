package com.estacionamento.apirestestacionamento;

import com.estacionamento.apirestestacionamento.models.Estacionamento;
import com.estacionamento.apirestestacionamento.models.Vaga;
import com.estacionamento.apirestestacionamento.repository.EstacionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class  ApirestEstacionamentoApplication implements CommandLineRunner {

	@Autowired
	private EstacionamentoRepository estacionamentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApirestEstacionamentoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Estacionamento estacionamento = new Estacionamento();
		Vaga vaga1 = new Vaga("A1");
		Vaga vaga2 = new Vaga("A2");
		Vaga vaga3 = new Vaga("A3");
		Vaga vaga4 = new Vaga("B1");
		Vaga vaga5 = new Vaga("B2");
		Vaga vaga6 = new Vaga("B3");
		Vaga vaga7 = new Vaga("C1");
		Vaga vaga8 = new Vaga("C2");
		Vaga vaga9 = new Vaga("C3");
		Vaga vaga10 = new Vaga("D1");
		Vaga vaga11 = new Vaga("D2");
		Vaga vaga12 = new Vaga("D3");
		Vaga vaga13 = new Vaga("E1");
		Vaga vaga14 = new Vaga("E2");
		Vaga vaga15 = new Vaga("E3");
		Vaga vaga16 = new Vaga("F3");

		vaga1.setEstacionamento(estacionamento);
		vaga2.setEstacionamento(estacionamento);
		vaga3.setEstacionamento(estacionamento);
		vaga4.setEstacionamento(estacionamento);
		vaga5.setEstacionamento(estacionamento);
		vaga6.setEstacionamento(estacionamento);
		vaga7.setEstacionamento(estacionamento);
		vaga8.setEstacionamento(estacionamento);
		vaga9.setEstacionamento(estacionamento);
		vaga10.setEstacionamento(estacionamento);
		vaga11.setEstacionamento(estacionamento);
		vaga12.setEstacionamento(estacionamento);
		vaga13.setEstacionamento(estacionamento);
		vaga14.setEstacionamento(estacionamento);
		vaga15.setEstacionamento(estacionamento);
		vaga16.setEstacionamento(estacionamento);

		estacionamento.getVagas().add(vaga1);
		estacionamento.getVagas().add(vaga2);
		estacionamento.getVagas().add(vaga3);
		estacionamento.getVagas().add(vaga4);
		estacionamento.getVagas().add(vaga5);
		estacionamento.getVagas().add(vaga6);
		estacionamento.getVagas().add(vaga7);
		estacionamento.getVagas().add(vaga8);
		estacionamento.getVagas().add(vaga9);
		estacionamento.getVagas().add(vaga10);
		estacionamento.getVagas().add(vaga11);
		estacionamento.getVagas().add(vaga12);
		estacionamento.getVagas().add(vaga13);
		estacionamento.getVagas().add(vaga14);
		estacionamento.getVagas().add(vaga15);
		estacionamento.getVagas().add(vaga16);

		estacionamentoRepository.save(estacionamento);
	}
}
