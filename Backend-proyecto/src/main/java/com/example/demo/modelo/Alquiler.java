package com.example.demo.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "alquiler")
public class Alquiler {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "idAlquiler")
	private long idAlquiler;
	
	
	@ManyToOne
	@JoinColumn(name = "identificacion", referencedColumnName = "identificacion")
	private Usuario identificacion;
	
	@ManyToOne
	@JoinColumn(name = "idVehiculo", referencedColumnName = "idVehiculo")
	private Vehiculo idVehiculo;
	
	@ManyToOne
	@JoinColumn(name = "idAdmin", referencedColumnName = "idAdmin")
	private Administrador idAdmin;
	
	@Column (name = "valorAlquiler", length = 20, nullable= false)
	private float valorAlquiler;
	
	@Column  ( name = "estado", length = 20, nullable = false)
	private String estado;
	
	@Column  ( name = "fechaInicio", length = 20, nullable = false)
	private String fechaInicio;
	
	@Column  ( name = "fechaEntrega", length = 20, nullable = false)
	private String fechaEntrega;

	public Alquiler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Alquiler(Usuario identificacion, Vehiculo idVehiculo, Administrador idAdmin, float valorAlquiler,
			String estado, String fechaInicio, String fechaEntrega) {
		super();
		this.identificacion = identificacion;
		this.idVehiculo = idVehiculo;
		this.idAdmin = idAdmin;
		this.valorAlquiler = valorAlquiler;
		this.estado = estado;
		this.fechaInicio = fechaInicio;
		this.fechaEntrega = fechaEntrega;
	}

	public long getIdAlquiler() {
		return idAlquiler;
	}

	public void setIdAlquiler(long idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public Usuario getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Usuario identificacion) {
		this.identificacion = identificacion;
	}

	public Vehiculo getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Vehiculo idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public Administrador getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Administrador idAdmin) {
		this.idAdmin = idAdmin;
	}

	public float getValorAlquiler() {
		return valorAlquiler;
	}

	public void setValorAlquiler(float valorAlquiler) {
		this.valorAlquiler = valorAlquiler;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}


	
	
}
