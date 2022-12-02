package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Rota {

	private Double distancia;
	private LocalDate data;
	
	public Rota() {	}

	public Rota(Double distancia, LocalDate data) {
		super();
		this.distancia = distancia;
		this.data = data;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	public LocalDate getData() {
		return data;
	}

	public void LocalDate(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Rota: " + distancia + "km,  Data: " + data;
	}
	
	
	
	
}
