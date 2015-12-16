package br.edu.horus.javabasico2015;

import java.util.Collection;

public abstract class Pessoa {
	private String nome;
	
	private Collection<Documento> documentos;
	
	public Pessoa(String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
