package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.LoginUsuario;
import com.example.demo.modelo.Usuario;

public interface LoginUsuariorepositorio extends JpaRepository<LoginUsuario,Long> {

	public LoginUsuario findByIdentificacion(Usuario identificacion);

}
