package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.modelo.Vehiculo;

public interface Vehiculorepositorio extends JpaRepository<Vehiculo,Long>{
	@Query(value = "SELECT * FROM vehiculo WHERE estado = 'Disponible'", nativeQuery = true)
	List<Vehiculo> findVehiculosDisponibles();

}
