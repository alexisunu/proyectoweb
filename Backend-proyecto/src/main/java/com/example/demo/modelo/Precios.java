package com.example.demo.modelo;

import jakarta.persistence.*;


@Entity
@Table(name= "preciosVehiculos")
public class Precios {
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "idPrecio")
	    private Long idPrecio;

	    @Column(name = "tipoVehiculo", unique = true)
	    private String tipoVehiculo;

	    @Column(name = "precio")
	    private float precio;
	    
	    
	    

		public Precios() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Precios(Long idPrecio, String tipoVehiculo, float precio) {
			super();
			this.idPrecio = idPrecio;
			this.tipoVehiculo = tipoVehiculo;
			this.precio = precio;
		}

		public Long getIdPrecio() {
			return idPrecio;
		}

		public void setIdPrecio(Long idPrecio) {
			this.idPrecio = idPrecio;
		}

		public String getTipoVehiculo() {
			return tipoVehiculo;
		}

		public void setTipoVehiculo(String tipoVehiculo) {
			this.tipoVehiculo = tipoVehiculo;
		}

		public float getPrecio() {
			return precio;
		}

		public void setPrecio(float precio) {
			this.precio = precio;
		}
	    
	    
	
	

}
