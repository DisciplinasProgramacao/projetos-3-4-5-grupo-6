package entities;

public class Combustivel {

	private Double precoDoCombustivel;
	private Double consumo;
	
	public Combustivel() {}

	public Combustivel(Double precoDoCombustivel, Double consumo) {
		this.precoDoCombustivel = precoDoCombustivel;
		this.consumo = consumo;
	}

	public Double getPrecoDoCombustivel() {
		return precoDoCombustivel;
	}

	public void setPrecoDoCombustivel(Double precoDoCombustivel) {
		this.precoDoCombustivel = precoDoCombustivel;
	}

	public Double getConsumo() {
		return consumo;
	}

	public void setConsumo(Double consumo) {
		this.consumo = consumo;
	}
	
	
	
}
