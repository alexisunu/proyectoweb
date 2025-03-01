package com.example.modelo;

import java.sql.Date;

public class Usuario {
	
	Long identificacion;
	String nombre;
	String apellido;
	int edad;
	Date fechaexpedicionlicencia;
	String categoriaLicencia;
	String vigenciaLicencia;
	String correo;
	int telefono;
	String password;
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(Long identificacion, String nombre, String apellido, int edad, Date fechaexpedicionlicencia,
			String categoriaLicencia, String vigenciaLicencia, String correo, int telefono, String password) {
		super();
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fechaexpedicionlicencia = fechaexpedicionlicencia;
		this.categoriaLicencia = categoriaLicencia;
		this.vigenciaLicencia = vigenciaLicencia;
		this.correo = correo;
		this.telefono = telefono;
		this.password = password;
	}


	public Long getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Date getFechaexpedicionlicencia() {
		return fechaexpedicionlicencia;
	}
	public void setFechaexpedicionlicencia(Date fechaexpedicionlicencia) {
		this.fechaexpedicionlicencia = fechaexpedicionlicencia;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
