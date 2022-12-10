package entities;

public class Carro extends AbstractVehicle{
	
	public Carro(String modelo, String placa, Integer capacidadeTanque, Double valorVenda, Double quilometragem) {
		super(modelo, placa, capacidadeTanque, valorVenda, quilometragem);
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
