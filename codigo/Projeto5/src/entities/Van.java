package entities;

import java.util.List;

public class Van extends AbstractVehicle{
	
	public Van(String modelo, String placa, Integer capacidadeTanque, Double valorVenda, Double quilometragem) {
		super(modelo, placa, capacidadeTanque, valorVenda, quilometragem);
		this.consumo = 12.0;
	}
	
	public Double getConsumo() {
		return consumo;
	}

	public void setConsumo(Double consumo) {
		this.consumo = consumo;
	}

	@Override
	public double calculaIPVA() {
		return valorVenda * 0.03;
	}

	@Override
	public double valorDoSeguro() {
		return valorVenda * 0.03;
	}

	@Override
	public double manutencao() {
		int ciclos = (int) (quilometragem / 10000);
		int ciclos2 = (int) (quilometragem / 1000);
		return (ciclos * 120) + (ciclos2 * 500);
	}

	@Override
	public double custoTotal() {
		return calculaIPVA() + valorDoSeguro() + manutencao();
	}

	@Override
	public double autonomia() {
		// TODO Auto-generated method stub
		return consumo * capacidadeTanque;
	}

	@Override
	public void adicionaRota(Rota rota) {

		double somaDasDistanciasDasRotas = 0;

		for (Rota r : rotas) {
			try {
				somaDasDistanciasDasRotas += r.getDistancia();
			}
			catch (Exception e) {
				System.out.println("Impossivel calcular soma das disntacias!\nDetalhe: " + e);
			}
		}

		try{

			if(autonomia() >= rota.getDistancia() && autonomia() >= somaDasDistanciasDasRotas) {
				rotas.add(rota);
			}
			else{ throw new Exception("Veiculo incapaz de receber tal rota"); }
		}

		catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}
	
}
