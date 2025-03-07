package com.example.demo.modelo;

import jakarta.persistence.*;

@Entity
@Table(name= "vehiculo")
public class Vehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column (name ="idVehiculo")
	private long idVehiculo;
	
	@Column(name= "tipoVehiculo")
	private String tipoVehiculo;
	
	@Column (name = "color")
	private String color;
	
	@Column (name = "placa", unique=true)
	private String placa;
	
	public Vehiculo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vehiculo(String tipoVehiculo, String color, String placa) {
		super();
		this.tipoVehiculo = tipoVehiculo;
		this.color = color;
		this.placa = placa;
	}
	public Long getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public String getTipoDeVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoDeVehiculo(String tipoDeVehiculo) {
		this.tipoVehiculo = tipoDeVehiculo;
	}
	
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
}
