package com.example.demo.controlador;

import java.util.List;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Vehiculo;
import com.example.demo.repositorio.Vehiculorepositorio;

@RestController
@RequestMapping("/vehiculos")
public class ControladorVehiculo {

    @Autowired
    private Vehiculorepositorio repositorioV;

    @GetMapping("/listaDisponibles")
    public List<Vehiculo> obtenerVehiculosDisponibles() {
        return repositorioV.findVehiculosDisponibles();
    }
}