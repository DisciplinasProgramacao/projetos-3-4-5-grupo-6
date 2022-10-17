package entities;

import java.util.Date;

public class Routes {

	private Date date;
	private Double distancia;
	private String origem;
	private String destino;
	
	public Routes () {}
	
	public Routes(Date date, Double distancia, String origem, String destino) {
		this.date = date;
		this.distancia = distancia;
		this.origem = origem;
		this.destino = destino;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	
}
