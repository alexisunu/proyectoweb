package com.example.demo.controlador;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.modelo.LoginUsuario;
import com.example.demo.modelo.Usuario;
import com.example.demo.repositorio.LoginUsuariorepositorio;
import com.example.demo.repositorio.Usuariorepositorio;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200/")
public class ControladorUsuario {
	
	@Autowired
	private LoginUsuariorepositorio repositorioL;
    
	@Autowired
    private Usuariorepositorio repositorioU;

   
	@PostMapping("/guardarU")
	public Usuario guardarUsuario(
	        @RequestBody Usuario usuario, 
	        @RequestParam String password) throws ParseException {

	    // Si necesitas convertir la fecha, asegúrate de que el objeto Usuario tenga el campo adecuado o haz la conversión aquí
	    //SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	    //Date fechaExpedicion = formato.parse(usuario.getFechaExpedicionLicencia());
	    //usuario.setFechaExpedicionLicencia(fechaExpedicion);

	    // Guarda el usuario
	    repositorioU.save(usuario);

	    // Procesa el password, por ejemplo, creando un objeto de login
	    LoginUsuario log = new LoginUsuario(usuario, password);
	    repositorioL.save(log);

	    return usuario;
	}

    
    
   
    
    

    // ✅ Endpoint para obtener todos los usuarios
    @GetMapping("/listarUsuarios")
    public List<Usuario> listarUsuarios() {
        return repositorioU.findAll();
    }
}

		
		
		
		
	


