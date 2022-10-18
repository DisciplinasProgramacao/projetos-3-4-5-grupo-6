package entities;

import java.util.ArrayList;
import java.util.List;

public class Frota {

	List<Vehicle> list = new ArrayList<>();
	
	public void incluirVeiculo(Vehicle vehicle) {
		list.add(vehicle);
	}
	
	public void removerVeiculo(Vehicle vehicle) {
		list.remove(vehicle);
	}
	
	public void getVeiculo(String modelo) {		
		for(Vehicle v : list) {
			if(modelo == v.getModelo()) {
				System.out.println(v);
			}
		}
	}
	
	
	
}
