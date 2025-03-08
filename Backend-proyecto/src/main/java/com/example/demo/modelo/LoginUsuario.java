package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "loginusuario")
public class LoginUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "idlogin")
	private Long idLogin;
	
	
	@OneToOne
	@JoinColumn(name = "identificacion",referencedColumnName = "identificacion")
	private Usuario identificacion;
	
	@Column(name="password")
	private String password;
	
	
	public LoginUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginUsuario(Usuario identificacion, String password) {
		super();
		this.identificacion = identificacion;
		this.password = password;
	}
	public Usuario getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(Usuario identificacion) {
		this.identificacion = identificacion;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
