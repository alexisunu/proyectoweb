package com.example.demo.repositorio;



import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.modelo.Alquiler;
import com.example.demo.modelo.Vehiculo;

public interface Alquilerrepositorio extends JpaRepository<Alquiler,Long>{
	
	Alquiler findByidVehiculo(Vehiculo idVehiculo);
	
}
