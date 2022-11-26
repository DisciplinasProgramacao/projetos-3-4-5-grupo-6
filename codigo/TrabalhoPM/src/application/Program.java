package application;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import entities.AbstractVehicle;
import entities.Carro;
import entities.Frota;
import entities.Rota;
import entities.Van;

public class Program {

	public static void main(String[] args) {
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Frota frota = new Frota();
		Rota r1 = new Rota(400.0, LocalDate.parse("05/10/2022", fmt1));
		Rota r2 = new Rota(300.0, LocalDate.parse("21/09/2022", fmt1));
		Rota r3 = new Rota(200.0, LocalDate.parse("22/09/2022", fmt1));
		Rota r4 = new Rota(500.0, LocalDate.parse("23/09/2022", fmt1));
		Rota r5 = new Rota(700.0, LocalDate.parse("24/09/2022", fmt1));
		
			
		
		AbstractVehicle v1 = new Carro("Carro HB20", "AAA1234", 50, 50000.00, 0.0);
		AbstractVehicle v2 = new Van("Van Scania", "ABC2222", 60, 80000.00, 0.0);
		AbstractVehicle v3 = new Carro("Carro Golf","FOG2022",  50, 90000.00, 0.0);
		AbstractVehicle v4 = new Carro("Carro Golf","FOG2022",  50, 90000.00, 0.0);
		AbstractVehicle v6 = new Carro("Carro Golf","FOG2022",  50, 90000.00, 0.0);
		AbstractVehicle v7 = new Carro("Carro Golf","FOG2022",  50, 90000.00, 0.0);
		AbstractVehicle v8 = new Carro("Carro Golf","FOG2022",  50, 90000.00, 0.0);
		AbstractVehicle v9 = new Carro("Carro Golf","FOG2022",  50, 90000.00, 0.0);
		
		
		frota.adicionarVeiculo(v1);
		frota.adicionarVeiculo(v2);
		frota.adicionarVeiculo(v3);
				
		v1.adicionaRota(r1);
		v2.adicionaRota(r5);
		v3.adicionaRota(r2);
				
				
		System.out.println("------------");
		
		
		for(AbstractVehicle v : frota.getVehicles()) {
			System.out.println(v);
		}
		
		System.out.println( String.format("%.2f",frota.quilometragemMediaDasRotas(frota.getVehicles())));
		

	}

}
 