package entities;

import java.util.List;

public class Furgao extends AbstractVehicle{

	private Double consumo;	
	
	public Furgao(String modelo, String placa, Integer capacidadeTanque, Double valorVenda, Double quilometragem) {
		super(modelo, placa,capacidadeTanque, valorVenda, quilometragem);
		this.consumo = 10.0;
	}		
	
	public Double getConsumo() {
		return consumo;
	}

	@Override
	public double calculaIPVA() {
		return valorVenda * 0.04;
	}

	@Override
	public double valorDoSeguro() {
		return (valorVenda * 0.05) + 300;
	}

	@Override
	public double manutencao() {
		int ciclos = (int) (quilometragem / 10000);
		return ciclos * 80;
	}

	@Override
	public double custoTotal() {
		return calculaIPVA() + valorDoSeguro() + manutencao();
	}

	@Override
	public double autonomia() {
		return consumo * capacidadeTanque;
	}

	@Override
	public void adicionaRota(Rota rota) {
		double somaDasDistanciasDasRotas = 0;		
		for(Rota r : rotas) {
			somaDasDistanciasDasRotas += r.getDistancia();
		}
		
		if(autonomia() >= rota.getDistancia() && autonomia() >= somaDasDistanciasDasRotas) {			
			rotas.add(rota);					
		} else {
			System.out.println("Veiculo incapaz de receber tal rota");
		}
		
	}

	@Override
	public String toString() {
		return modelo + " - Rotas" + rotas + " - Gastos R$" + custoTotal(); 
	}


}
