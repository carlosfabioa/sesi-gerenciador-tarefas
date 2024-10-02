package com.sesi.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sesi.tarefas.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer>{

}
