package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelo.Administrador;
import com.example.demo.repositorio.Administradorrepositorio;

@RestController
@RequestMapping("/administrador/")
@CrossOrigin(origins = "http://localhost:4200/")
public class ControladorAdministrador {
	
	@Autowired
	private Administradorrepositorio repositorioAdmin;
	
	
	@PostMapping("/login")
	public boolean Login(@RequestParam Administrador admi)
	{
		
		Administrador admin = (Administrador) repositorioAdmin.findByUsuario(admi.getUsuario());
		
		if (admin == null) {
			return false;
		}
		else {
			if(admi.getContraseña().equals(admin.getContraseña())) {
				return true;
			}
		}
		return false;
		
	}
	
	
	

}
