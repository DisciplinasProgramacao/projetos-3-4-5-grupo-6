package application;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Caminhao;
import entities.Carro;
import entities.Furgao;
import entities.Routes;
import entities.Van;
import entities.Vehicle;

// Diretório C:\\temp\\carros.txt

public class Program {

	public static void main(String[] args) {		
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);		
		
		List<Vehicle> list = new ArrayList<>();
		
		System.out.println("Enter file path");
		String sourceFileStr = sc.nextLine();
		
		File sourceFile = new File(sourceFileStr);
		String sourceFolderStr= sourceFile.getParent();
		
		boolean sucess = new File(sourceFolderStr + "/outTesteCarros").mkdir();
		
		String targetFileStr = sourceFolderStr + "\\out\\RelatorioCarros.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
			String itemCsv = br.readLine();
			
			while(itemCsv != null) {
				
				String[] fields = itemCsv.split(",");
				String modelo = fields[0];
				Integer capacidadeTanque = Integer.parseInt(fields[1]);
				Double valorVenda = Double.parseDouble(fields[2]);
				Double kmTotal = Double.parseDouble(fields[3]);
				Double kmDiario = Double.parseDouble(fields[4]);
				Double consumo = Double.parseDouble(fields[5]);					
				
				list.add(new Vehicle(modelo, capacidadeTanque, valorVenda, kmTotal, kmDiario, consumo,  new Routes(null, 300.0, "Belo horizonte", "Rio de janeiro")));
								
				System.out.println(itemCsv);
				itemCsv = br.readLine();
			}
			
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {
				for(Vehicle item : list) {
					bw.write("Relatorio: Modelo: " 
				+ item.getModelo() + ", IPVA: $" 
			    + String.format("%.2f", item.calculaIPVA(item.getValorVenda())) 
			    + ", Autonomia: " + item.autonomia()
			    + "km, Outras Despesas: $" 
			    + String.format("%.2f", item.calculaDespesas()));
					bw.newLine();
				}
				
				System.out.println();
				System.out.println(targetFileStr + " Created");
				
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}			
			
		} catch (IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}		
		
		//System.out.println("FOLDER CREATED: " + sucess);
		
		sc.close();
	}

}
