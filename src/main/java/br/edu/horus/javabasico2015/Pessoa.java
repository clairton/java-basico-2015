package br.edu.horus.javabasico2015;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo")
public abstract class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	
	private String nome;
	
	@Transient
	private Collection<Documento> documentos;
	
	@Deprecated
	public Pessoa(){
	}
	
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
