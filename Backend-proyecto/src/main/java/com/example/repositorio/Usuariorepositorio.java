package com.example.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.modelo.Usuario;


public interface Usuariorepositorio extends JpaRepository<Usuario,Long>  {

}
