package entities;

public class Rota {
	//Adicionar Data
	private double distancia;

	public Rota() {	}

	public Rota(double distancia) {
		this.distancia = distancia;
	}


	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	@Override
	public String toString() {
		return "Rota: " + distancia + " km";
	}	
		

}
