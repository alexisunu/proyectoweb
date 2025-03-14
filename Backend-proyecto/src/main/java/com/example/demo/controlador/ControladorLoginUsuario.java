package com.example.demo.controlador;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.LoginUsuario;
import com.example.demo.modelo.Usuario;
import com.example.demo.repositorio.LoginUsuariorepositorio;
import com.example.demo.repositorio.Usuariorepositorio;

@RestController
@RequestMapping("/login")
public class ControladorLoginUsuario {
	 @Autowired
	 private LoginUsuariorepositorio repositorioL;
	 
	 @Autowired
	 private Usuariorepositorio repositorioU;
	 
	 @PostMapping("/loginU")
		public boolean Login(@RequestBody Map<String, String> objecttype)
		{
		 	Long usuario = Long.parseLong(objecttype.get("usuario")); 
			String password = objecttype.get("password");
			
		
			
			Usuario usu = repositorioU.findById(usuario).orElse(null);
			LoginUsuario log = repositorioL.findByIdentificacion(usu);
			
			if (usu != null && password.equals(log.getPassword())) {
				return true;
			}
			
			return false;
			
		}
	}
	

