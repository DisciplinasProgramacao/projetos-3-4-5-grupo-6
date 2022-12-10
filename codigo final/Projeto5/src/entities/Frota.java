package entities;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

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
	
	public double quilometragemMediaDasRotas() {
		
		AtomicReference<Double> somaDasQuilometragens = new AtomicReference<>(0.0);

		vehicles.forEach(veiculo ->{

			somaDasQuilometragens.updateAndGet(v -> (v + veiculo.getQuilometragem()));

		});

		return somaDasQuilometragens.get() / vehicles.size();
	}
	
	
	
}
