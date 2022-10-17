package entities;

public class Carro extends Vehicle{
	
	public Carro() {}
		
	public Carro(String modelo, Integer capacidadeTanque, Double valorVenda, Double kmTotal, Double kmDiaria,
			Double consumo, Routes rota) {
		super(modelo, capacidadeTanque, valorVenda, kmTotal, kmDiaria, consumo, rota);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculaIPVA(Double valorVenda) {
		return getValorVenda() * 0.04;
	}
	
	@Override
	public double calculaSeguro(Double valorVenda) {
		return (getValorVenda() * 0.05) + 300;
	}
	
	@Override
	public double autonomia() {
		return getCapacidadeTanque() * getConsumo();
	}
	
	@Override
	public double calculaDespesas() {
		int distancia = (int) (this.getKmTotal() / 1000);
		return distancia * 80.0;
	}
	
	
}
