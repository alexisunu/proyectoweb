package com.example.modelo;

import jakarta.persistence.*;

@Entity
@Table(name= "vehiculo")
public class Vehiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column (name ="idVehiculo")
	private long idVehiculo;
	
	@Column(name= "tipoDeVehiculo")
	private String tipoDeVehiculo;
	
	
	@Column (name= "estado")
	private String estado;

	@Column (name = "Color")
	private String Color;
	
	@Column (name = "placa")
	private String placa;
	
	public Vehiculo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vehiculo(Long idVehiculo, String tipoDeVehiculo, String estado, String color, String placa) {
		super();
		this.idVehiculo = idVehiculo;
		this.tipoDeVehiculo = tipoDeVehiculo;
		this.estado = estado;
		Color = color;
		this.placa = placa;
	}
	public Long getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public String getTipoDeVehiculo() {
		return tipoDeVehiculo;
	}
	public void setTipoDeVehiculo(String tipoDeVehiculo) {
		this.tipoDeVehiculo = tipoDeVehiculo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
}
