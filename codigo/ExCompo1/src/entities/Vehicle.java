package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
public class Vehicle {

	private String modelo;
	private String placa;
	private Integer capacidadeTanque;
	private Double valorVenda;
	private Double kilometragem;
	private Double consumo;
	
	private List<Rota> rotas = new ArrayList<>();
	
	public Vehicle() {}
	
	public Vehicle(String modelo, String placa, Integer capacidadeTanque, Double valorVenda, Double kilometragem, Double consumo) {
		this.modelo = modelo;
		this.placa = placa;
		this.capacidadeTanque = capacidadeTanque;
		this.valorVenda = valorVenda;
		this.kilometragem = kilometragem;
		this.consumo = consumo;
	}

	public String toString(){
		String result = "Modelo: " + modelo +"\n";
		result += "Placa: "+ placa +"\n";
		result+= "Capacidade do tanque: "+ capacidadeTanque + "\n";
		result+= "Valor venda: "+ valorVenda +"\n";
		result+= "Kilometragem: "+ kilometragem +"\n";

		return result;
	}

	public double totalRotas(){

		double totalRotas = 0;
		
		for (Rota rota : rotas) {

			totalRotas+=rota.getDistancia();
			
		}

		return totalRotas;
	}
		
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
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
		return 5;
	}
	
	public double calculaSeguro() {
		return 50;
	}
	public double calculaManutencao() {
		return 100;
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
