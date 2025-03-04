package com.example.modelo;

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
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "idVehiculo", referencedColumnName = "idVehiculo")
	private Vehiculo idvehiculo;
	
	@ManyToOne
	@JoinColumn(name = "idAdmin", referencedColumnName = "idAdmin")
	private Administrador idamin;
	
	@Column (name = "valorAlquiler", length = 20, nullable= false)
	private float valoralquiler;
	
	@Column  ( name = "estado", length = 20, nullable = false)
	private String estatus;
	
	@Column  ( name = "fechaInicio", length = 20, nullable = false)
	private String fechai;
	
	@Column  ( name = "fechaEntrega", length = 20, nullable = false)
	private String fechae;

	public Alquiler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Alquiler(long idAlquiler, Usuario usuario, Vehiculo idvehiculo, Administrador idamin, float valoralquiler,
			String estatus, String fechai, String fechae) {
		super();
		this.idAlquiler = idAlquiler;
		this.usuario = usuario;
		this.idvehiculo = idvehiculo;
		this.idamin = idamin;
		this.valoralquiler = valoralquiler;
		this.estatus = estatus;
		this.fechai = fechai;
		this.fechae = fechae;
	}

	public long getIdAlquiler() {
		return idAlquiler;
	}

	public void setIdAlquiler(long idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vehiculo getIdvehiculo() {
		return idvehiculo;
	}

	public void setIdvehiculo(Vehiculo idvehiculo) {
		this.idvehiculo = idvehiculo;
	}

	public Administrador getIdamin() {
		return idamin;
	}

	public void setIdamin(Administrador idamin) {
		this.idamin = idamin;
	}

	public float getValoralquiler() {
		return valoralquiler;
	}

	public void setValoralquiler(float valoralquiler) {
		this.valoralquiler = valoralquiler;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getFechai() {
		return fechai;
	}

	public void setFechai(String fechai) {
		this.fechai = fechai;
	}

	public String getFechae() {
		return fechae;
	}

	public void setFechae(String fechae) {
		this.fechae = fechae;
	}
	
	
	
}
