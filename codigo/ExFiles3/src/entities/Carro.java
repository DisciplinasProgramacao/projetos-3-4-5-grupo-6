package entities;

public class Carro extends Vehicle{
	
	public Carro() {}
		
	public Carro(String modelo, Integer capacidadeTanque, Double valorVenda, Double kmTotal, Double kmDiaria,
			Double consumo, Routes rota) {
		super(modelo, capacidadeTanque, valorVenda, kmTotal, kmDiaria, consumo, rota);
	}

	@Override
	public double calculaIPVA() {
		return getValorVenda() * 0.04;
	}
	
	@Override
	public double calculaSeguro() {
		return (getValorVenda() * 0.05) + 300;
	}
	
	@Override
	public double autonomia() {
		return getCapacidadeTanque() * getConsumo();
	}
	
	@Override
	public double calculaDespesas() {
		
		return getKmTotal() / 80.0 ;
	}
	
	
}
