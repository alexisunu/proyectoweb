package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.modelo.Precios;

public interface Preciosrepositorio extends JpaRepository<Precios,Long> {
	
	public Precios findBytipoVehiculo(String tipoVehiculo);

}
