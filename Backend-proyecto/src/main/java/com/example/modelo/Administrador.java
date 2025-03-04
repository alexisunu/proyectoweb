package com.example.modelo;

import jakarta.persistence.*;



@Entity
@Table(name= "admin")
public class Administrador {
	

	@Id
	@Column(name = "idAdmin")
	private long idAdmin;
	
	@Column(name = "usuario" , length = 50, nullable = false)
	private String usuario;
	
	@Column(name = "contraseña" , length = 50, nullable = false)
	private String contraseña;
	
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
