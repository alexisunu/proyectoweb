package com.example.demo.controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Alquiler;
import com.example.demo.modelo.Vehiculo;
import com.example.demo.repositorio.Alquilerrepositorio;
import com.example.demo.repositorio.Vehiculorepositorio;

@RestController
@RequestMapping("/Alquiler")
@CrossOrigin(origins = "http://localhost:4200/")
public class ControladorAlquiler{

		@Autowired
		private Alquilerrepositorio repositorioA;
		
		@Autowired
		private Vehiculorepositorio repositorioV;
		
		@GetMapping("/entregarVehiculo")
		public Alquiler Entregarvehiculo (@RequestParam String placa ) {
			
			System.out.print(placa);
			
			Vehiculo vehiculoPlaca = repositorioV.findByplaca(placa);
			
			Alquiler AlquilerEntregar = repositorioA.findByidVehiculo(vehiculoPlaca);
			
			
					
			if (AlquilerEntregar != null ) {
				
				String estado = AlquilerEntregar.getEstado();	
				if(estado.equals("En espera")) {
					return AlquilerEntregar;
				}
				
				return null;
				
			}
			
			return null;
		}

		
		@PostMapping("/cambiarEstado")
		public boolean cambiarEstado (@RequestBody Alquiler a) {
			
			a.setEstado("Entregado");
			
			this.repositorioA.save(a);
			
			return true;
		}
		
		@GetMapping("/devolverVehiculo")
		public Alquiler buscarId (@RequestParam Long id) {
			
			Alquiler alquilerEncontrado = this.repositorioA.findById(id).orElse(null);
			
			
			if (alquilerEncontrado != null && alquilerEncontrado.getEstado().equals("Entregado")) {
				return alquilerEncontrado;
			}
					
			return null;
		}
		

		@DeleteMapping("/borraralquiler")
		public boolean borrarAlquiler (@RequestBody Alquiler alquilerBorrar){
			
			Optional<Alquiler> optionalAlquiler = repositorioA.findById(alquilerBorrar.getIdAlquiler());
			
			if (optionalAlquiler != null) {
				repositorioA.delete(alquilerBorrar);
				return true;
				
			}else {
				return false;
			}
			
			
		}
		
		
}
