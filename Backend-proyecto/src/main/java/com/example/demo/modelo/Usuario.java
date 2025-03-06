package com.example.demo.modelo;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@Column(name = "identificacion")
	private long identificacion;
	
	@Column(name = "nombrecompleto")
	private String nombreCompleto;
	
	@Column(name = "fechaexpedicionlicencia")
	private Date fechaExpedicionLicencia;
	
	@Column(name = "categoriaLicencia")
	private String categoriaLicencia;
	
	@Column(name = "vigenciaLicencia")
	private String vigenciaLicencia;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "telefono")
	private int telefono;
	
	@OneToOne(mappedBy ="identificacion",cascade = CascadeType.ALL )
	private LoginUsuario loginusuario;
	
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(Long identificacion, String nombreCompleto,  Date fechaExpedicionLicencia,
			String categoriaLicencia, String vigenciaLicencia, String correo, int telefono, String password) {
		super();
		this.identificacion = identificacion;
		this.nombreCompleto = nombreCompleto;
		this.fechaExpedicionLicencia = fechaExpedicionLicencia;
		this.categoriaLicencia = categoriaLicencia;
		this.vigenciaLicencia = vigenciaLicencia;
		this.correo = correo;
		this.telefono = telefono;
	}

	public long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(long identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Date getFechaExpedicionLicencia() {
		return fechaExpedicionLicencia;
	}

	public void setFechaExpedicionLicencia(Date fechaExpedicionLicencia) {
		this.fechaExpedicionLicencia = fechaExpedicionLicencia;
	}

	public String getCategoriaLicencia() {
		return categoriaLicencia;
	}

	public void setCategoriaLicencia(String categoriaLicencia) {
		this.categoriaLicencia = categoriaLicencia;
	}

	public String getVigenciaLicencia() {
		return vigenciaLicencia;
	}

	public void setVigenciaLicencia(String vigenciaLicencia) {
		this.vigenciaLicencia = vigenciaLicencia;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}



}
