package entities;

public class Caminhao extends Vehicle{

	public Caminhao () {}	
	
	public Caminhao(String modelo, Integer capacidadeTanque, Double valorVenda, Double kmTotal, Double kmDiaria,
			Double consumo, Routes rota) {
		super(modelo, capacidadeTanque, valorVenda, kmTotal, kmDiaria, consumo, rota);
	}

	@Override
	public double calculaIPVA(Double valorVenda) {
		return getValorVenda() * 0.01;
	}
	
	@Override
	public double calculaSeguro(Double valorVenda) {
		return (getValorVenda() * 0.02) + 2000;
	}
	
	@Override
	public double autonomia() {
		return getCapacidadeTanque() * getConsumo();
	}
	
	@Override
	public double calculaDespesas() {
		int manutencao = (int) (this.getKmTotal() / 20000);
		manutencao = manutencao * 1000;
		int vistoria = (int) (this.getKmTotal() / 30000);
		vistoria = vistoria * 1000;
		return manutencao + vistoria;
	}
}
