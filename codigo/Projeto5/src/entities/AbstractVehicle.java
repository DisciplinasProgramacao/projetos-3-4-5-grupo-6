package entities;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractVehicle implements iVehicle {

	
	protected String modelo;
	protected String placa;
	protected Integer capacidadeTanque;
	protected Double valorVenda;
	protected Double quilometragem;
	
	List<Rota> rotas = new ArrayList<>();	
	
	protected Double consumo;
	protected Combustivel combustivel;
	
	public AbstractVehicle(String modelo, String placa, Integer capacidadeTanque, Double valorVenda,
			Double quilometragem) {
		this.modelo = modelo;
		this.placa = placa;
		this.capacidadeTanque = capacidadeTanque;
		this.valorVenda = valorVenda;
		this.quilometragem = quilometragem;
		
	}
		
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Double getConsumo() {
		return consumo;
	}

	public void setConsumo(Double consumo) {
		this.consumo = consumo;
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


	public Double getQuilometragem() {
		return quilometragem;
	}


	public void setQuilometragem(Double quilometragem) {
		this.quilometragem = quilometragem;
	}

	public List<Rota> getRotas() {
		return rotas;
	}

	

		
}
