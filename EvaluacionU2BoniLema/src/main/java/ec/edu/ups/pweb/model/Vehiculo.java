package ec.edu.ups.pweb.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ Entity
@Table(name = "tbl_vehiculo")
public class Vehiculo {
	@Id
	private int numero;
	private String marca;
	private String modelo;
	private String anio;
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	

}
