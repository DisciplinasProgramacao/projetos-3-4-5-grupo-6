package entities;

import java.util.ArrayList;
import java.util.List;

public class Frota {

	List<AbstractVehicle> vehicles = new ArrayList<>();

	public Frota() {}
	
	public Frota(List<AbstractVehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public List<AbstractVehicle> getVehicles() {
		return vehicles;
	}

	public void adicionarVeiculo(AbstractVehicle vehicle) {
		vehicles.add(vehicle);
	}
	
	public AbstractVehicle consultaVeiculo(AbstractVehicle vehicle) {
		
		for(AbstractVehicle v : vehicles) {		
			if(vehicle.getPlaca() == v.getPlaca()) {
				return vehicle;
			}
		}
		return null;		
	}
	
	public double quilometragemMediaDasRotas(List<AbstractVehicle> vehicles) {		
		
		double somaDasQuilometragens = 0.0;
		for(AbstractVehicle v : vehicles) {
			somaDasQuilometragens += v.getQuilometragem();
			
		}
		
		double media = somaDasQuilometragens / vehicles.size();
		
		return media;
	}
	
	
	
}
