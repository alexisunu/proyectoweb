package com.example.demo.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public List<Vehiculo> obtenerVehiculosDisponibles(@RequestBody Map<String, String> objecttype) {
    	String tipo = objecttype.get("tipo");   	
        return repositorioV.findVehiculosDisponibles(tipo);
    }
    
    
    
}