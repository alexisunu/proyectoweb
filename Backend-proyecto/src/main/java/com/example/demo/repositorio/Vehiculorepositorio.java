package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Vehiculo;

public interface Vehiculorepositorio extends JpaRepository<Vehiculo,Long>{

}
