package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.*;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		

		int opcao = 1;

		List<Carro> listaDeCarros = new ArrayList<Carro>();
		List<Caminhao> listaDeCaminhoes = new ArrayList<Caminhao>();
		List<Furgao> listaDeFurgoes = new ArrayList<Furgao>();
		List<Van> listaDeVans = new ArrayList<Van>();
		Frota frota = new Frota();

		//Criar vehicles
		//criaçao de carros
		Carro carro1Vehicle = new Carro("UNO", "ADB1234", 40, 12000.00, 40000.00, 8.00);
		Carro carro2Vehicle = new Carro("sandero", "tvd1345", 45, 34000.00, 30000.00, 15.00);
		Carro carro3Vehicle = new Carro("HuB", "abt3455", 50, 45000.00, 134000.00, 13.00);

		//criaçao de furgoes
		Furgao furgao1Vehicle = new Furgao("HuB", "abt3455", 50, 45000.00, 13400.00, 7.00);
		Furgao furgao2Vehicle = new Furgao("FoB", "ztx1255", 70, 34000.00, 14000.00, 10.00);
		Furgao furgao3Vehicle = new Furgao("UKa", "opp1498", 32, 16000.00, 16000.00, 13.00);

		//criaçao de vans
		Van van1Vehicle = new Van("zen", "ptx6679", 34, 34000.00, 22000.00, 8.00);
		Van van2Vehicle = new Van("glau", "azp3209", 28, 8900.00, 32000.00, 10.00);
		Van van3Vehicle = new Van("huy", "tru8192", 30, 7800.00, 22000.00, 12.00);

		//criaçao caminhao
		Caminhao caminhao1Vehicle = new Caminhao("mercedes", "trup9281", 56, 12000.00, 230000.00, 11.00);
		Caminhao caminhao2Vehicle = new Caminhao("chop", "kio23984", 33, 220000.00, 78617.00, 8.00);
		Caminhao caminhao3Vehicle = new Caminhao("azur", "bpt6722", 40, 123000.00, 40543.00, 9.00);

		//Menu de opcoes
		while (opcao!=0){

			Scanner sc = new Scanner(System.in);
			
			System.out.println("\n1-Adicionar veiculos");
			System.out.println("2-Adicionar veiculos na frota");
			System.out.println("3-Mostrar veiculos da frota");
			System.out.println("4-Localizar veiculos na frota");
			System.out.println("5-Adicionar rota a veiculo da frota");
			System.out.println("6-Mostrar rotas dos veiculos da frota");
			System.out.println("7-Ler Arquivo");
			System.out.println("8-Quilometragem media de todas as rotas da empresa");
			System.out.println("0-Sair");
			System.out.print("Opcao: ");
			opcao = sc.nextInt();


			switch (opcao) {
				case 1 -> {

					//Adcionando carros na lista de carros
					listaDeCarros.add(carro1Vehicle);
					listaDeCarros.add(carro2Vehicle);
					listaDeCarros.add(carro3Vehicle);

					//Adcionando furgoes na lista de furgoes
					listaDeFurgoes.add(furgao1Vehicle);
					listaDeFurgoes.add(furgao2Vehicle);
					listaDeFurgoes.add(furgao3Vehicle);

					//Adcionando van na lista de vans
					listaDeVans.add(van1Vehicle);
					listaDeVans.add(van2Vehicle);
					listaDeVans.add(van3Vehicle);

					//Adcionando caminhao na lista de caminhoes
					listaDeCaminhoes.add(caminhao1Vehicle);
					listaDeCaminhoes.add(caminhao2Vehicle);
					listaDeCaminhoes.add(caminhao3Vehicle);
					System.out.println("\nTodos os veiculos foram adicionados com sucesso!");
				}
				case 2 -> {

					//Adcionando veiculos na frota
					frota.addVehicle(carro3Vehicle);
					frota.addVehicle(caminhao2Vehicle);
					frota.addVehicle(van1Vehicle);
					frota.addVehicle(furgao3Vehicle);
					System.out.println("\nTodos os veiculos foram adicionados na frota com sucesso!");
				}

				case 3 -> {

					for (Vehicle vehicle : frota.getListaVehicles()) {

						System.out.println(vehicle);

					}

				}

				case 4 -> {
					
					//Localizando o veciulo dentro da frota, pela placa
					String placa;
					Scanner sc2 = new Scanner(System.in);

					System.out.print("Digite a placa do veiculo: ");
					placa = sc2.nextLine();
					frota.localizaVehicle(placa);
				}

				case 5 -> {

					Rota rota = new Rota();
					String distancia;
					String placa;
					int cont = 0;
					Scanner sc2 = new Scanner(System.in);

					System.out.print("\nDigite a rota que deseja inserir: ");
					distancia = sc2.nextLine();

					rota.setDistancia(Double.parseDouble(distancia));

					System.out.print("\nDigite a placa do veiculo que deseja inserir a rota: ");
					placa = sc2.nextLine();

					for (Vehicle veiculo : frota.getListaVehicles()) {

						if(veiculo.getPlaca().equals(placa)){

							veiculo.addRota(rota);

						}
						else{

							cont++;

						}

					}

					if(cont == frota.getListaVehicles().size()){

						System.out.println("Nenhum veiculo encontrado com essa placa: " + placa);
					}

				}

				case 6 -> {

					for (Vehicle vehicle : frota.getListaVehicles()) {

						System.out.println("Modelo: " + vehicle.getModelo());
						System.out.println("Rotas: " + vehicle.getRotas());

					}
				}

				case 7 -> {

					LerArquivo lerArquivo = new LerArquivo();

					lerArquivo.lerArquivo();

				}
				
				case 8 -> {
					System.out.println("Media das distancias das rotas = " + frota.quilometragemMediaTotal(frota.getListaVehicles()));
					
				}

				case 0 -> {
					System.out.println("Saindo...");
					sc.close();
				}

				default -> System.out.println("Opcao invalida!");

			}

		}

	}
}

