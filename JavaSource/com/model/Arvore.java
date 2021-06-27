package com.model;

import java.util.List;

public class Arvore {
	
	private List<Arvore> filho;
	private boolean isPasta;
	private String nome;
	private String path;
	
	public boolean isPasta() {
		return isPasta;
	}
	public void setPasta(boolean isPasta) {
		this.isPasta = isPasta;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public List<Arvore> getFilho() {
		return filho;
	}
	public void setFilho(List<Arvore> filho) {
		this.filho = filho;
	}

}
