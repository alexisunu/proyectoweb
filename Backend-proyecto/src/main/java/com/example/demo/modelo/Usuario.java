 package com.example.demo.modelo;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@Column(name = "identificacion")
	private long identificacion;
	
	@Column(name = "nombrecompleto")
	private String nombreCompleto;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern= "yyy-MM-dd")
	@Column(name = "fechaexpedicionlicencia")
	private Date fechaExpedicionLicencia;
	
	@Column(name = "categoriaLicencia")
	private String categoriaLicencia;
	
	@Column(name = "vigenciaLicencia")
	private String vigenciaLicencia;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "telefono", columnDefinition=" varchar(20)")
	private String telefono;
	
	@OneToOne(mappedBy ="identificacion",cascade = CascadeType.ALL )
	private LoginUsuario loginusuario;
	
	
	
	public Usuario() {
		super();
	}

	public Usuario(Long identificacion, String nombreCompleto,  Date fechaExpedicionLicencia,
			String categoriaLicencia, String vigenciaLicencia, String correo, String telefono) {
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



}
