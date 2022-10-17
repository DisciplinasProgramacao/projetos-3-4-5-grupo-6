package entities;

public class Vehicle {
	
	private String modelo;
	private Integer capacidadeTanque;
	private Double valorVenda;
	private Double kmTotal;
	private Double kmDiaria;
	private Double consumo;
	
	private Routes rota;
	
	public Vehicle () {}

	

	public Vehicle(String modelo, Integer capacidadeTanque, Double valorVenda, Double kmTotal, Double kmDiaria,
			Double consumo, Routes rota) {
		this.modelo = modelo;
		this.capacidadeTanque = capacidadeTanque;
		this.valorVenda = valorVenda;
		this.kmTotal = kmTotal;
		this.kmDiaria = kmDiaria;
		this.consumo = consumo;
		this.rota = rota;
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

	public Double getKmTotal() {
		return kmTotal;
	}

	public void setKmTotal(Double kmTotal) {
		this.kmTotal = kmTotal;
	}

	public Double getKmDiaria() {
		return kmDiaria;
	}

	public void setKmDiaria(Double kmDiaria) {
		this.kmDiaria = kmDiaria;
	}

	public Double getConsumo() {
		return consumo;
	}

	public void setConsumo(Double consumo) {
		this.consumo = consumo;
	}
		
	public Routes getRota() {
		return rota;
	}

	public void setRota(Routes rota) {
		this.rota = rota;
	}

	public double calculaIPVA() {
		return valorVenda * 4/100;
	}
	
	public double calculaSeguro() {
		return (valorVenda*0.05) + 300;
	}
	
	public double autonomia() {
		return capacidadeTanque * consumo;
	}
	
	public double calculaDespesas () {
		return 0.0;
	}
	
	public boolean validaRota () {
		return true;
	}
}
