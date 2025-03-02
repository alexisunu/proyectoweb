package com.example.modelo;

public class LoginUsuario {
	Long identificacion;
	String password;
	public LoginUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginUsuario(Long identificacion, String password) {
		super();
		this.identificacion = identificacion;
		this.password = password;
	}
	public Long getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
