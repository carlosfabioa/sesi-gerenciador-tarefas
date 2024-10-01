package com.sesi.tarefas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sesi.tarefas.model.TarefaCategoria;
import com.sesi.tarefas.model.Usuario;
import com.sesi.tarefas.repository.TarefaCategoriaRepository;
import com.sesi.tarefas.repository.UsuarioRepository;

@Configuration
public class CarregaBaseDeDados {

	@Autowired
	private TarefaCategoriaRepository tarefaCategoriaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
		
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
			
			
		};
		
	}
	
}
