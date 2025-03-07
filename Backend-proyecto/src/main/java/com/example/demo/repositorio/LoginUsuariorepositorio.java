package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.LoginUsuario;

public interface LoginUsuariorepositorio extends JpaRepository<LoginUsuario,Long> {

}
