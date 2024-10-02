package com.sesi.tarefas.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private StatusTarefa status;
	private LocalDate dataEntrega;
	
	@Enumerated(EnumType.STRING)
	private Prioridade prioridade;
	
	private boolean visivel;
	
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private TarefaCategoria categoria;
	
	@ManyToOne
	private Usuario usuario;
	
		

	public Tarefa() {
	}

	public Tarefa(int id, String descricao, StatusTarefa status, LocalDate dataEntrega, Prioridade prioridade,
			boolean visivel, TarefaCategoria categoria, Usuario usuario) {
		this.id = id;
		this.descricao = descricao;
		this.status = status;
		this.dataEntrega = dataEntrega;
		this.prioridade = prioridade;
		this.visivel = visivel;
		this.categoria = categoria;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusTarefa getStatus() {
		return status;
	}

	public void setStatus(StatusTarefa status) {
		this.status = status;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public boolean isVisivel() {
		return visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

	public TarefaCategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(TarefaCategoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
