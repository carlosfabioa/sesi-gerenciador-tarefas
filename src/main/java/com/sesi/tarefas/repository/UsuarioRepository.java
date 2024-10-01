package com.sesi.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sesi.tarefas.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
