package entities;

import java.util.ArrayList;
import java.util.List;

public class Frota {

	
	private final List<Vehicle> vehicles = new ArrayList<>();
	
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

	
}
