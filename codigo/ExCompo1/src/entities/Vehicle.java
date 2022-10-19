package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



public class Vehicle {

	private String modelo;
	private Integer capacidadeTanque;
	private Double valorVenda;
	private Double kilometragem;
	private Double consumo;
	
	private List<Rota> rotas = new ArrayList<>();
	
	public Vehicle() {}
	
	public Vehicle(String modelo, Integer capacidadeTanque, Double valorVenda, Double kilometragem, Double consumo, List<Rota> rotas) {
		this.modelo = modelo;
		this.capacidadeTanque = capacidadeTanque;
		this.valorVenda = valorVenda;
		this.kilometragem = kilometragem;
		this.rotas = rotas;
		this.consumo = consumo;
	}

	public List<Rota> getRotas() {
		return rotas;
	}
		
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getCapacidadeTanque() {
		return capacidadeTanque;
	}

	public void setCapacidadeTanque(Integer capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Double getKilometragem() {
		return kilometragem;
	}

	public void setKilometragem(Double kilometragem) {
		this.kilometragem = kilometragem;
	}	
	
	public Double getConsumo() {
		return consumo;
	}

	public void setConsumo(Double consumo) {
		this.consumo = consumo;
	}

	public double autonomia() {
		return getCapacidadeTanque() * getConsumo();
	}

	public void addRota(Rota rota) {
		if(rota.getDistancia() <= autonomia()) {		
		rotas.add(rota);
		}
	}
	
	public void removeRota(Rota rota) {
		rotas.remove(rota);
	}
	
	public double calculaIPVA() {
		return 0.0;
	}
	
	public double calculaSeguro() {
		return 0.0;
	}
	public double calculaManutencao() {
		return 0.0;
	}
	
	public double custoTotal() {
		return calculaManutencao() + calculaIPVA() + calculaSeguro();
	}
	
	public void odometro(Rota rota) {
		for (Rota r : rotas) {
			kilometragem += r.getDistancia();			
			}
	}
}