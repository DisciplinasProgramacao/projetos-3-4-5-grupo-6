package entities;

import java.util.List;

public class Carro extends Vehicle{

	public Carro() {}

	public Carro(String modelo, Integer capacidadeTanque, Double valorVenda, Double kilometragem, Double consumo,
			List<Rota> rotas) {
		super(modelo, capacidadeTanque, valorVenda, kilometragem, consumo, rotas);
	}

	@Override
	public double calculaIPVA() {
		return getValorVenda() * 0.04;
	}
	
	@Override
	public double calculaSeguro() {
		return (getValorVenda() * 0.05) + 300.00 ;
	}
	
	@Override
	public double calculaManutencao() {
		int ciclos = (int) (getKilometragem() / 10000);
		return ciclos * 80;
	}
	
	@Override
	public double custoTotal() {
		return calculaManutencao() + calculaIPVA() + calculaSeguro();
	}

	
}