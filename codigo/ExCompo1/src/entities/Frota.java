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
	
	
	
}
