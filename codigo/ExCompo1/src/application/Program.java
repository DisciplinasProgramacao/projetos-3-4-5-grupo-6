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
				Integer capacidadeTanque = Integer.parseInt(fields[1]);
				Double valorVenda = Double.parseDouble(fields[2]);
				Double kilometragem = Double.parseDouble(fields[3]);
				Double consumo = Double.parseDouble(fields[4]);					
				
				if(modelo.equalsIgnoreCase("Carro")) {						
					listaDeCarros.add(new Carro(modelo, capacidadeTanque, valorVenda, kilometragem, consumo));
					System.out.println(new Carro(modelo, capacidadeTanque, valorVenda, kilometragem, consumo));
				}
				if(modelo.equalsIgnoreCase("Caminhao")) {						
					listaDeCaminhoes.add(new Caminhao(modelo, capacidadeTanque, valorVenda, kilometragem, consumo));
				}
				if(modelo.equalsIgnoreCase("Furgao")) {										
					Furgao furgao = new Furgao(modelo, capacidadeTanque, valorVenda, kilometragem, consumo);
					listaDeFurgoes.add(furgao);
				}
				if(modelo.equalsIgnoreCase("Van")) {										
					Van van = new Van(modelo, capacidadeTanque, valorVenda, kilometragem, consumo);
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
			System.out.println("Manutenção: " + vehicle.calculaManutencao());
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

