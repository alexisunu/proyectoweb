package com.example.modelo;

public class Administrador {
	
	Long idAdmin;
	String usuario;
	String contraseña;
	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Administrador(Long idAdmin, String usuario, String contraseña) {
		super();
		this.idAdmin = idAdmin;
		this.usuario = usuario;
		this.contraseña = contraseña;
	}
	public Long getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
}
