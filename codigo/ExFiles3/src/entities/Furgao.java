package entities;

public class Furgao extends Vehicle {
	
	public Furgao () {}
	
	public Furgao(String modelo, Integer capacidadeTanque, Double valorVenda, Double kmTotal, Double kmDiaria,
			Double consumo, Routes rota) {
		super(modelo, capacidadeTanque, valorVenda, kmTotal, kmDiaria, consumo, rota);
		
	}

	@Override
	public double calculaIPVA() {
		return getValorVenda() * 0.03;
	}
	
	@Override
	public double calculaSeguro() {
		return getValorVenda() * 0.03;
	}
	
	@Override
	public double autonomia() {
		return getCapacidadeTanque() * getConsumo();
	}
	
	@Override
	public double calculaDespesas() {
		int alinhamento = (int) (this.getKmTotal() / 10000);
		alinhamento = alinhamento * 120;
		int vistoria = (int) (this.getKmTotal() / 10000);
		vistoria = vistoria * 500;
		return alinhamento + vistoria;
	}

}
