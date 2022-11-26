package entities;

import java.util.List;

public class Caminhao extends Vehicle {

	public Caminhao() {	}

	public Caminhao(String modelo, String placa, Integer capacidadeTanque, Double valorVenda, Double kilometragem, Double consumo) {
		super(modelo, placa, capacidadeTanque, valorVenda, kilometragem, consumo);
	}
	
	@Override
	public double calculaIPVA() {
		return getValorVenda() * 0.01;
	}
	
	@Override
	public double calculaSeguro() {
		return (getValorVenda() * 0.02) + 2000.00 ;
	}
	
	@Override
	public double calculaManutencao() {
		int ciclos = (int) (getKilometragem() / 20000);
		int ciclos2 = (int) (getKilometragem() / 30000);
		return (ciclos * 1000) + (ciclos2 * 1000);
	}
	
	@Override
	public double custoTotal() {
		return calculaManutencao() + calculaIPVA() + calculaSeguro();
	}
		

}
