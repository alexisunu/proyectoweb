package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.modelo.Alquiler;
import com.example.demo.modelo.Vehiculo;

public interface Alquilerrepositorio extends JpaRepository<Alquiler,Long>{
	@Query(value ="Select v.* FROM vehiculo v"
			+ " LEFT JOIN alquiler a ON v.id_vehiculo = a.id_vehiculo"
			+ " WHERE a.id_vehiculo is null and v.tipo_vehiculo = :tipo ",nativeQuery=true)
}
