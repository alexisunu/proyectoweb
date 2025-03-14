package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.modelo.Alquiler;
import com.example.demo.modelo.Vehiculo;

public interface Alquilerrepositorio extends JpaRepository<Alquiler,Long>{
	
}
