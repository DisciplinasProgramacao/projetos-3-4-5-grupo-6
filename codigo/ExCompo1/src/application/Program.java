package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import entities.Caminhao;
import entities.Carro;
import entities.Rota;
import entities.Vehicle;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Vehicle vehicle = null;
		Caminhao caminhao = null;
		
		System.out.print("Modelo do veiculo: ");
		String modelo = sc.nextLine();
		System.out.print("Capacidade do tanque: ");
		Integer capacidadeTanque = sc.nextInt();
		System.out.print("Valor de venda: ");
		Double valorVenda = sc.nextDouble();
		System.out.print("Kilometragem: ");
		Double kilometragem = sc.nextDouble();
		System.out.print("Consumo: ");
		Double consumo = sc.nextDouble();	
			
		vehicle = new Carro(modelo, capacidadeTanque, valorVenda, kilometragem, consumo,null);		

		if(modelo == "Caminhao") {		
			vehicle = new Caminhao(modelo, capacidadeTanque, valorVenda, kilometragem, consumo,null);
		}
			
		System.out.print("Informe a distancia da rota: ");
		Double distancia = sc.nextDouble();
		
		//vehicle.addRota(new Rota(distancia));
		
		System.out.println("Modelo: " + vehicle.getModelo());
		System.out.println("Autonomia: " + vehicle.autonomia());
		System.out.println("IPVA: " +vehicle.calculaIPVA());
		System.out.println("Seguro: " + vehicle.calculaSeguro());
		System.out.println("Manutenção: " + vehicle.calculaManutencao());
		System.out.println("Custo total:" + vehicle.custoTotal());
		System.out.println("Rotas: " + vehicle.getRotas());
				
		/*
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		*/
		sc.close();
	}
}