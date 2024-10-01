package com.sesi.tarefas.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sesi.tarefas.model.TarefaCategoria;
import com.sesi.tarefas.repository.TarefaCategoriaRepository;

import jakarta.websocket.server.PathParam;

@Controller
public class TarefaCategoriaController {

	@Autowired
	TarefaCategoriaRepository tarefaCategoriaRepository;
	
	@GetMapping("/listarCategoria")
	public String listarCategoria(Model modelo) {
		modelo.addAttribute("categorias", tarefaCategoriaRepository.findAll());
		return "listarTarefaCategoria";
	}
	
	@GetMapping("editarCategoria/{id}")
	public String editarCategoria(@PathVariable("id") int id, Model modelo) {
		Optional<TarefaCategoria> categoriaOpt = tarefaCategoriaRepository.findById(id);
		
		if(categoriaOpt.isPresent()) {
			modelo.addAttribute("categoria", categoriaOpt.get());
			return "formularioTarefaCategoria";
		}else {
			return "redirect:/listarTarefaCategoria";
		}
	}
	
	@GetMapping("/formularioTarefaCategoria")
	public String mostrarFormulario(Model modelo) {
		modelo.addAttribute("categoria", new TarefaCategoria());
		return "formularioTarefaCategoria";
	}
	
	@PostMapping("/salvarCategoria")
	public String salvarCategoria(@ModelAttribute TarefaCategoria categoria) {
		tarefaCategoriaRepository.save(categoria);
		return "redirect:/listarCategoria";
	}
	
	@GetMapping("/excluirCategoria/{id}")
	public String excluirCategoria(@PathVariable("id") int id) {
		tarefaCategoriaRepository.deleteById(id);
		return "redirect:/listarCategoria";
	}
	
}
