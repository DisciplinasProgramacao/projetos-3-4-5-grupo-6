package entities;

public class Furgao extends Vehicle{

	public Furgao() {}

	public Furgao(String modelo, Integer capacidadeTanque, Double valorVenda, Double kilometragem, Double consumo) {
		super(modelo, capacidadeTanque, valorVenda, kilometragem, consumo);
	}
	
	@Override
	public double calculaIPVA() {
		return getValorVenda() * 0.03;
	}
	
	@Override
	public double calculaSeguro() {
		return (getValorVenda() * 0.03);
	}
	
	@Override
	public double calculaManutencao() {
		int ciclos = (int) (getKilometragem() / 10000);
		int ciclos2 = (int) (getKilometragem() / 1000);
		return (ciclos * 120) + (ciclos2 * 500);
	}
	
	@Override
	public double custoTotal() {
		return calculaManutencao() + calculaIPVA() + calculaSeguro();
	}
	
	
}
