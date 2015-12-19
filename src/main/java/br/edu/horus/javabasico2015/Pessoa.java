package br.edu.horus.javabasico2015;

import java.util.Collection;
import java.util.Collections;

public abstract class Pessoa {
	private String nome;
	
	private Collection<Documento> documentos;
	
	public Pessoa(String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void adicionar(Documento documento){
		this.documentos.add(documento);
	}
	
	public Collection<Documento> getDocumentos() {
		return Collections.unmodifiableCollection(documentos);
	}
}
