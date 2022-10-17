package entities;

public class Caminhao extends Vehicle{

	
	
	
	@Override
	public double calculaIPVA() {
		return super.getValorVenda() * 0.01;
	}
	
	@Override
	public double calculaSeguro() {
		return (super.getValorVenda() * 0.02) + 2000;
	}
	
	@Override
	public double autonomia() {
		return getCapacidadeTanque() * getConsumo();
	}
	
	@Override
	public double calculaDespesas() {
		int distancia = (int) (this.getKmTotal() / 20000);
		return distancia * 1000.0;
	}
}
