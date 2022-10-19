package entities;

import java.util.List;

public class Caminhao extends Vehicle {

	public Caminhao() {	}

	public Caminhao(String modelo, Integer capacidadeTanque, Double valorVenda, Double kilometragem, Double consumo,
			List<Rota> rotas) {
		super(modelo, capacidadeTanque, valorVenda, kilometragem, consumo, rotas);
	}
		

}
