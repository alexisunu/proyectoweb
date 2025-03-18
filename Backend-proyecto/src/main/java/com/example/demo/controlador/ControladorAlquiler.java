package com.example.demo.controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		
		

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
		
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
				
				Date fechaInici = sdf.parse(fechaInicio);
				Date fechaEntreg = sdf.parse(fechaEntrega);
			    long diffInMillies = fechaEntreg.getTime() - fechaInici.getTime();
			    long dias = (diffInMillies / (1000 * 60 * 60 * 24))+1;
			    
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
		public Map<String, Object> buscarId (@RequestParam Long id) throws ParseException {
			
			Alquiler alquilerEncontrado = this.repositorioA.findById(id).orElse(null);
			
			
			if (alquilerEncontrado != null && alquilerEncontrado.getEstado().equals("Entregado")) {
				
				Map<String, Object> response = new HashMap<>();
				String tipo = alquilerEncontrado.getIdVehiculo().getTipoDeVehiculo();
				Precios precio = repositorioP.findBytipoVehiculo(tipo);
				LocalDate fechaActual = LocalDate.now();
				Date fechaHoy = Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant());			
				Long diasmm = fechaHoy.getTime() - alquilerEncontrado.getFechaEntrega().getTime();
				Long dias = diasmm / (1000 * 60 * 60 * 24);
				
				
				if(dias < 0 ) {
					dias = 0L;
				}
				
				Long totaldiasadicionales= (long) (dias*precio.getPrecio());
				
				
				response.put("alquiler", alquilerEncontrado );
				
				response.put("diasadicionales", totaldiasadicionales);
				
				return response;
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
		
		@GetMapping("/obteneralquileres")
		public List<Alquiler> obterneAlqileres (@RequestParam Long identificacion){
			
			Usuario usu = repositorioU.findById(identificacion).orElse(null);
			
			List<Alquiler> listaalquileres = repositorioA.findByIdentificacion(usu);
			
			List<Alquiler> listaAlquileresEnEspera = new ArrayList<>();

			
			for (int i = 0; i<listaalquileres.size();i++) {
				
				String estado = listaalquileres.get(i).getEstado();
				
				if(estado.equals("En espera")) {
					
					listaAlquileresEnEspera.add(listaalquileres.get(i));
					
				}
				
			}
			
			return listaAlquileresEnEspera;
		}
		
		
}
