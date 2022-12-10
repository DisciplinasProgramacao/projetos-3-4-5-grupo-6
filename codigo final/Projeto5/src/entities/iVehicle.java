package entities;

public interface iVehicle {
			
	double calculaIPVA();
	double valorDoSeguro();	
	double manutencao();
	double custoTotal();
	double autonomia();
	void adicionaRota(Rota rota);
	
}
