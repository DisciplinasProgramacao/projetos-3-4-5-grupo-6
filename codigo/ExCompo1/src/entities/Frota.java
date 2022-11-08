package entities;

import java.util.ArrayList;
import java.util.List;

public class Frota {
	
	private final List<Vehicle> vehicles = new ArrayList<>();
	public List<Vehicles> top3rotas = new ArrayList<>();
	
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	
	public void removeVehicle(Vehicle vehicle) {
		vehicles.remove(vehicle);
	}
	
	public double getVehicle(Vehicle vehicle) {
		return vehicle.custoTotal();
	}

	public List<Vehicle> getListaVehicles() {
		return vehicles;
	}

	public void localizaVehicle(String placa){

		int cont = 0;

		for (Vehicle veiculo : vehicles) {

			if(veiculo.getPlaca().equals(placa)){
				
				System.out.println("Veiculo encontrado!\n");
				System.out.println(veiculo);
				break;
			}
			else{

				cont++;

			}
			
		}

		if(cont == vehicles.size()){

			System.out.println("Nenhum veiculo encontrado com a placa: " + placa);
		}
				
	}
	

		
	public double quilometragemMediaTotal(List<Vehicle> vehicles) {
		
		double distanciaTotal = 0.0;
		for(Vehicle v : vehicles) {
			distanciaTotal += v.totalRotas();
		}		
				
		return distanciaTotal/vehicles.size();
	}
	
	//Receber uma lista de veiculos, checar quais tem a maior quantidade de rotas e jogar o top3 na em outra lista
	public void top3VeiculosComMaisRotas(List<Vehicle> vehicles) {
		
		Vehicle maisRotas = vehicles.get(0);
		for(Vehicle v : vehicles) {
			(if v.getRotas() > maisRotas) {
				maisRotas = v;
				top3rotas.
			}
		}
	}
	
}

