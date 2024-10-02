package com.sesi.tarefas.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sesi.tarefas.model.Prioridade;
import com.sesi.tarefas.model.StatusTarefa;
import com.sesi.tarefas.model.Tarefa;
import com.sesi.tarefas.model.TarefaCategoria;
import com.sesi.tarefas.model.Usuario;
import com.sesi.tarefas.repository.TarefaCategoriaRepository;
import com.sesi.tarefas.repository.TarefaRepository;
import com.sesi.tarefas.repository.UsuarioRepository;

@Configuration
public class CarregaBaseDeDados {

	@Autowired
	private TarefaCategoriaRepository tarefaCategoriaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TarefaRepository tarefaRepository;
		
	@Bean
	CommandLineRunner executar() {
		
		return args ->{
			
			Usuario usuario = new Usuario();
			usuario.setNome("Fernando");
			usuario.setSenha("madu❤");
			
			usuarioRepository.save(usuario);
			
			
			Usuario usuario1 = new Usuario();
			usuario1.setNome("Giovana");
			usuario1.setSenha("estudaMenina");
			
			usuarioRepository.save(usuario1);
			
			
			
			TarefaCategoria categoria = new TarefaCategoria();
			categoria.setNome("Estudos");
			
			tarefaCategoriaRepository.save(categoria);
			
			
			TarefaCategoria categoria1 = new TarefaCategoria();
			categoria1.setNome("Pesquisa");
			tarefaCategoriaRepository.save(categoria1);
			
			Tarefa tarefa = new Tarefa();
			tarefa.setDescricao("Estudar Spring Boot");
			tarefa.setStatus(StatusTarefa.A_FAZER);
			tarefa.setDataEntrega(LocalDate.now().plusDays(1));
			tarefa.setPrioridade(Prioridade.MEDIA);
			tarefa.setVisivel(true);
			tarefa.setCategoria(categoria);
			tarefa.setUsuario(usuario1);
			
			tarefaRepository.save(tarefa);
			
			Tarefa tarefa1 = new Tarefa();
			tarefa1.setDescricao("Estudar Spring Security");
			tarefa1.setStatus(StatusTarefa.A_FAZER);
			tarefa1.setDataEntrega(LocalDate.now().plusDays(1));
			tarefa1.setPrioridade(Prioridade.MEDIA);
			tarefa1.setVisivel(true);
			tarefa1.setCategoria(categoria1);
			tarefa1.setUsuario(usuario);
			
			tarefaRepository.save(tarefa1);
		};
		
	}
	
}
