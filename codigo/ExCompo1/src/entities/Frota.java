package entities;

import java.util.ArrayList;
import java.util.List;

public class Frota {

	
	private List<Vehicle> vehicles = new ArrayList<>();	
	
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	
	public void removeVehicle(Vehicle vehicle) {
		vehicles.remove(vehicle);
	}
	
	public double getVehicle(Vehicle vehicle) {
		return vehicle.custoTotal();
	}
	
	
	public void localizaVehicle(String placa){

		for (Vehicle veiculo : vehicles) {

			if(veiculo.getPlaca().equals(placa)){
				
				System.out.println("Veiculo " + veiculo.getModelo() + "encontrado!");
			}
			else{
				
				System.out.println("Nao encontrou nenhum veiculo");
			}
			
		}
				
	}

	
}
