package com.example.demo.controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
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
import com.example.demo.modelo.Precios;
import com.example.demo.modelo.Usuario;
import com.example.demo.modelo.Vehiculo;
import com.example.demo.modelo.Administrador;
import com.example.demo.repositorio.Administradorrepositorio;
import com.example.demo.repositorio.Alquilerrepositorio;
import com.example.demo.repositorio.Preciosrepositorio;
import com.example.demo.repositorio.Usuariorepositorio;
import com.example.demo.repositorio.Vehiculorepositorio;

@RestController
@RequestMapping("/Alquiler")
@CrossOrigin(origins = "http://localhost:4200/")
public class ControladorAlquiler{

		@Autowired
		private Alquilerrepositorio repositorioA;
		
		@Autowired
		private Vehiculorepositorio repositorioV;
		
		@Autowired
		private Usuariorepositorio repositorioU;
		
		@Autowired
		private Administradorrepositorio repositorioAd;
		
		@Autowired
		private Preciosrepositorio repositorioP;
		
		
		@PostMapping("/crearalquiler")
		public Alquiler crearAlquiler(@RequestParam String identificacion, 
									 @RequestParam String placa,
									 @RequestParam String fechaInicio,
									 @RequestParam String fechaEntrega) throws ParseException {
		
			Long id = Long.parseLong(identificacion);
			
			Usuario usuario = repositorioU.findById(id).orElse(null);
			
			Vehiculo vehiculo = repositorioV.findByplaca(placa);
			
			Administrador a = repositorioAd.findById((long) 2).orElse(null);
			
			
			
			if(usuario != null && vehiculo!= null) {
				
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
				Date fechaInici = sdf.parse(fechaInicio);
				Date fechaEntreg = sdf.parse(fechaEntrega);
			    long diffInMillies = fechaEntreg.getTime() - fechaInici.getTime();
			    long dias = diffInMillies / (1000 * 60 * 60 * 24);
			    
			    String tipo = vehiculo.getTipoDeVehiculo();
			    Precios precioTipo = repositorioP.findBytipoVehiculo(tipo);
			    float precio = precioTipo.getPrecio();
			    float valorTotal = precio * dias;
			    
			    String estado = "En espera";
				Alquiler alquilerNuevo = new Alquiler(usuario,vehiculo,a,valorTotal,estado,fechaInici,fechaEntreg);
				
				repositorioA.save(alquilerNuevo);
				
				
				return alquilerNuevo;
			}
			
			
			
			return null;
			
		}
		
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
