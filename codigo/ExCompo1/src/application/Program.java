package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Caminhao;
import entities.Carro;
import entities.Frota;
import entities.Furgao;
import entities.Van;
import entities.Vehicle;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Carro> listaDeCarros = new ArrayList<Carro>();
		List<Caminhao> listaDeCaminhoes = new ArrayList<Caminhao>();
		List<Furgao> listaDeFurgoes = new ArrayList<Furgao>();
		List<Van> listaDeVans = new ArrayList<Van>();
		Frota f1 = new Frota();

		
		//Criar vehicles
		//criaçao de carros
		Carro carro1Vehicle = new Carro( "UNO", "ADB1234", 40, 12000.00, 40000.00, 8.00);
		Carro carro2Vehicle = new Carro("sandero", "tvd1345", 45, 34000.00, 30000.00, 15.00);
		Carro carro3Vehicle = new Carro("HuB", "abt3455", 50, 45000.00, 134000.00, 13.00);

		//Adcionando carros na lista de carros
		listaDeCarros.add(carro1Vehicle);
		listaDeCarros.add(carro2Vehicle);
		listaDeCarros.add(carro3Vehicle);

		//criaçao de furgoes
		Furgao furgao1Vehicle = new Furgao("HuB", "abt3455", 50, 45000.00, 13400.00, 7.00);
		Furgao furgao2Vehicle = new Furgao("FoB", "ztx1255", 70, 34000.00, 14000.00, 10.00);
		Furgao furgao3Vehicle = new Furgao("UKa", "opp1498", 32, 16000.00, 16000.00, 13.00);

		//Adcionando furgoes na lista de furgoes
		listaDeFurgoes.add(furgao1Vehicle);
		listaDeFurgoes.add(furgao2Vehicle);
		listaDeFurgoes.add(furgao3Vehicle);

		//criaçao de vans
		Van van1Vehicle = new Van("zen", "ptx6679", 34, 34000.00, 22000.00, 8.00);
		Van van2Vehicle = new Van("glau", "azp3209", 28, 8900.00, 32000.00, 10.00);
		Van van3Vehicle = new Van("huy", "tru8192", 30, 7800.00, 22000.00, 12.00);

		//Adcionando van na lista de vans
		listaDeVans.add(van1Vehicle);
		listaDeVans.add(van2Vehicle);
		listaDeVans.add(van3Vehicle); 

		//criaçao caminhao
		Caminhao caminhao1Vehicle = new Caminhao("mercedes", "trup9281", 56, 12000.00, 230000.00, 11.00);
		Caminhao caminhao2Vehicle = new Caminhao("chop", "kio23984", 33, 220000.00, 78617.00, 8.00);
		Caminhao caminhao3Vehicle = new Caminhao("azur", "bpt6722", 40, 123000.00, 40543.00, 9.00);

		//Adcionando caminhao na lista de caminhoes
		listaDeCaminhoes.add(caminhao1Vehicle);
		listaDeCaminhoes.add(caminhao2Vehicle); 
		listaDeCaminhoes.add(caminhao3Vehicle);  

		Frota frota = new Frota();

		frota.addVehicle(carro3Vehicle);
		frota.addVehicle(caminhao2Vehicle);
		frota.addVehicle(van1Vehicle);
		frota.addVehicle(furgao3Vehicle);

		frota.localizaVehicle("abt3455");


		//LER DO ARQUIVO TXT
		String sourceFileStr = "C:\\temp\\carros.txt";
		
		File sourceFile = new File(sourceFileStr);
		String sourceFolderStr= sourceFile.getParent();		
		
		String targetFileStr = sourceFolderStr + "\\out\\RelatorioCompleto.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
			String itemCsv = br.readLine();
			
			while(itemCsv != null) {				
				String[] fields = itemCsv.split(",");
				String modelo = fields[0];
				String placa = fields [1];
				Integer capacidadeTanque = Integer.parseInt(fields[2]);
				Double valorVenda = Double.parseDouble(fields[3]);
				Double kilometragem = Double.parseDouble(fields[4]);
				Double consumo = Double.parseDouble(fields[5]);					
				
				if(modelo.equalsIgnoreCase("Carro")) {						
					listaDeCarros.add(new Carro(modelo, placa, capacidadeTanque, valorVenda, kilometragem, consumo));
					System.out.println(new Carro(modelo, placa, capacidadeTanque, valorVenda, kilometragem, consumo));
				}
				if(modelo.equalsIgnoreCase("Caminhao")) {						
					listaDeCaminhoes.add(new Caminhao(modelo, placa, capacidadeTanque, valorVenda, kilometragem, consumo));
				}
				if(modelo.equalsIgnoreCase("Furgao")) {										
					Furgao furgao = new Furgao(modelo, placa, capacidadeTanque, valorVenda, kilometragem, consumo);
					listaDeFurgoes.add(furgao);
				}
				if(modelo.equalsIgnoreCase("Van")) {										
					Van van = new Van(modelo, placa, capacidadeTanque, valorVenda, kilometragem, consumo);
					listaDeVans.add(van);
				}
								
				//System.out.println(itemCsv);
				itemCsv = br.readLine();	
				System.out.println(listaDeCarros.size());
				
			}	
			
			/*
			System.out.print("Informe a distancia da rota: ");
			Double distancia = sc.nextDouble();
			Rota r = new Rota(distancia);
			vehicle.addRota(r);
			 */
			
			//vehicle.addRota(new Rota(distancia));
			
			/*
			System.out.println("Modelo: " + vehicle.getModelo());
			System.out.println("Autonomia: " + vehicle.autonomia());
			System.out.println("IPVA: " +vehicle.calculaIPVA());
			System.out.println("Seguro: " + vehicle.calculaSeguro());
			System.out.println("Manuten��o: " + vehicle.calculaManutencao());
			System.out.println("Custo total:" + vehicle.custoTotal());
			System.out.println("Rotas: " + vehicle.getRotas());
		*/
			
			// O bloco try escreve o arquivo TXT 
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {
				bw.write("RELATORIO COMPLETO");
				bw.newLine();				
				for(Carro c : listaDeCarros) {
					bw.write("Modelo: " 
				+ c.getModelo() + ", IPVA: $" 
			    + c.calculaIPVA() 
			    + ", Autonomia: " + c.autonomia()
			    + "km, kilometragem total: " 
			    + c.getKilometragem()
			    + ", Outras Despesas: $" 
			    + String.format("%.2f", c.custoTotal()));
					bw.newLine();
					bw.write("--------------------------------------------------------------------------------------------");
					bw.newLine();
				}
				for(Caminhao c : listaDeCaminhoes) {
					bw.write("Modelo: " 
				+ c.getModelo() + ", IPVA: $" 
			    + c.calculaIPVA() 
			    + ", Autonomia: " + c.autonomia()
			    + "km, kilometragem total: " 
			    + c.getKilometragem()
			    + ", Outras Despesas: $" 
			    + String.format("%.2f", c.custoTotal()));
					bw.newLine();
					bw.write("--------------------------------------------------------------------------------------------");
					bw.newLine();
				}
				for(Van v : listaDeVans) {
					bw.write("Modelo: " 
				+ v.getModelo() + ", IPVA: $" 
			    + v.calculaIPVA() 
			    + ", Autonomia: " + v.autonomia()
			    + "km, kilometragem total: " 
			    + v.getKilometragem()
			    + ", Outras Despesas: $" 
			    + String.format("%.2f", v.custoTotal()));
					bw.newLine();
					bw.write("--------------------------------------------------------------------------------------------");
					bw.newLine();
				}
				for(Furgao f : listaDeFurgoes) {
					bw.write("Modelo: " 
				+ f.getModelo() + ", IPVA: $" 
			    + f.calculaIPVA() 
			    + ", Autonomia: " + f.autonomia()
			    + "km, kilometragem total: " 
			    + f.getKilometragem()
			    + ", Outras Despesas: $" 
			    + String.format("%.2f", f.custoTotal()));
					bw.newLine();
					bw.write("--------------------------------------------------------------------------------------------");
					bw.newLine();
				}
				
			}
				catch (IOException e) {
					System.out.println("Error: " + e.getMessage());
				}	
			} catch (IOException e) {
				System.out.println("ERROR: " + e.getMessage());
			}	
					
	
		sc.close();
		}
}

