package entities;

public class Carro extends Vehicle{
	
	public Carro() {}
	
	@Override
	public double calculaIPVA() {
		return super.getValorVenda() * 0.04;
	}
	
	@Override
	public double calculaSeguro() {
		return (super.getValorVenda() * 0.05) + 300;
	}
	
	@Override
	public double autonomia() {
		return getCapacidadeTanque() * getConsumo();
	}
	
	@Override
	public double calculaDespesas() {
		double distancia = this.getKmTotal() % 1000;
		return distancia * 80.0;
	}
	
	
}
