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
public class ControladorUsuario {
	
	@Autowired
	private LoginUsuariorepositorio repositorioL;
    
	@Autowired
    private Usuariorepositorio repositorioU;

   
    @PostMapping("/guardarU")
    public Usuario guardarUsuario(
            @RequestParam Long identificacion,
            @RequestParam String nombrecompleto,
            @RequestParam String fechaExpedicionLicencia,
            @RequestParam String categoriaLicencia,
            @RequestParam String vigenciaLicencia,
            @RequestParam String correo,
            @RequestParam String telefono,
            @RequestParam String password) throws ParseException{

         

        SimpleDateFormat formato = new SimpleDateFormat("yyy-MM-dd");
        Date fechaExpedicion = formato.parse(fechaExpedicionLicencia);
        
        
        Usuario usu = new Usuario(identificacion, nombrecompleto,fechaExpedicion,categoriaLicencia,vigenciaLicencia,correo,telefono);
        
        repositorioU.save(usu);

        LoginUsuario log = new LoginUsuario(usu, password);
        
        repositorioL.save(log);
        
      
        return usu;
    }
    
    
   
    
    

    // ✅ Endpoint para obtener todos los usuarios
    @GetMapping("/listarUsuarios")
    public List<Usuario> listarUsuarios() {
        return repositorioU.findAll();
    }
}

		
		
		
		
	


