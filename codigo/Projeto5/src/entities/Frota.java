package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
	
	public AbstractVehicle consultaVeiculo(String placa) {
		
		for(AbstractVehicle veiculo : vehicles) {
			if(Objects.equals(placa, veiculo.getPlaca())) {
				return veiculo;
			}
		}
		return null;		
	}
	
	public double quilometragemMediaDasRotas(List<AbstractVehicle> vehicles) {		
		
		double somaDasQuilometragens = 0.0;
		for(AbstractVehicle v : vehicles) {
			somaDasQuilometragens += v.getQuilometragem();
			
		}

		return somaDasQuilometragens / vehicles.size();
	}
	
	
	
}
