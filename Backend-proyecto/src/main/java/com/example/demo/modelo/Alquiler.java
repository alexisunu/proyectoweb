package com.example.demo.modelo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;


@Entity
@Table(name = "alquiler")
public class Alquiler {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAlquiler")
	private long idAlquiler;
	
	
	@ManyToOne()
	@JoinColumn(name = "identificacion", referencedColumnName = "identificacion")
	private Usuario identificacion;
	
	@ManyToOne()
	@JoinColumn(name = "idVehiculo", referencedColumnName = "idVehiculo")
	private Vehiculo idVehiculo;
	
	@ManyToOne()
	@JoinColumn(name = "idAdmin", referencedColumnName = "idAdmin")
	private Administrador idAdmin;
	
	@Column (name = "valorAlquiler", length = 20, nullable= false)
	private float valorAlquiler;
	
	@Column  ( name = "estado", length = 20, nullable = false)
	private String estado;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yy")
	@Column  ( name = "fechaInicio", length = 20, nullable = false)
	private Date fechaInicio;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yy")
	@Column  ( name = "fechaEntrega", length = 20, nullable = false)
	private Date fechaEntrega;

	public Alquiler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Alquiler(Usuario identificacion, Vehiculo idVehiculo, Administrador idAdmin, float valorAlquiler,
			String estado, Date fechaInicio, Date fechaEntrega) {
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

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}


	
	
}
