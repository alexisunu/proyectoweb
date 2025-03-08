package com.example.demo.controlador;

import java.util.List;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Vehiculo;
import com.example.demo.repositorio.Vehiculorepositorio;

@RestController
@RequestMapping("/vehiculos")
@CrossOrigin(origins = "http://localhost:4200/")
public class ControladorVehiculo {

    @Autowired
    private Vehiculorepositorio repositorioV;

    @PostMapping("/listaDisponibles")
    public List<Vehiculo> obtenerVehiculosDisponibles(@RequestParam String tipo) {
        return repositorioV.findVehiculosDisponibles(tipo);
    }
}