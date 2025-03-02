package com.example.modelo;

public class Alquiler {
	Long idAlquiler;
	int identificacion;
	int idVehiculo;
	int idAdmin;
	float valorAlquiler;
	String estado;
	String fechaInicio;
	String fechaEntrega;
	public Alquiler() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Alquiler(Long idAlquiler, int identificacion, int idVehiculo, int idAdmin, float valorAlquiler,
			String estado, String fechaInicio, String fechaEntrega) {
		super();
		this.idAlquiler = idAlquiler;
		this.identificacion = identificacion;
		this.idVehiculo = idVehiculo;
		this.idAdmin = idAdmin;
		this.valorAlquiler = valorAlquiler;
		this.estado = estado;
		this.fechaInicio = fechaInicio;
		this.fechaEntrega = fechaEntrega;
	}
	public Long getIdAlquiler() {
		return idAlquiler;
	}
	public void setIdAlquiler(Long idAlquiler) {
		this.idAlquiler = idAlquiler;
	}
	public int getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}
	public int getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public int getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(int idAdmin) {
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
