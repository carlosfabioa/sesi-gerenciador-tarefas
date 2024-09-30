package com.sesi.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TarefaCategoriaController {

	@GetMapping("/listarCategoria")
	public String listarCategoria() {
		
		return "listarTarefaCategoria";
	}
	
}
