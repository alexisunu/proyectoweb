 package com.example.demo.controlador;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public boolean Login(@RequestBody Map<String, String> objecttype)
	{
		
		String usuario = objecttype.get("usuario");
		String password = objecttype.get("password");
		
		Administrador admin = (Administrador) repositorioAdmin.findByUsuario(usuario);
		
		if (admin != null && password.equals(admin.getContraseña())) {
			return true;
		}
		
		return false;
		
	}
	
	
	

}
