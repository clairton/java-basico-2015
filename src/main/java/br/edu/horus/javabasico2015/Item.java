package br.edu.horus.javabasico2015;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("item")
@Entity
public class Item extends Identificavel {
	
	@Id
	private Integer id = new Random().nextInt();
	
	@Identificador(isCaseSensitive = false)
	@XStreamAlias("xpto")
	private String nome;
	
	private Double valor;
	
	@Deprecated
	public Item() {}	
	
	public Item(String nome, Double valor){
		this.valor = valor;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public String getNome() {
		return nome;
	}

	@Override
	public int hashCode() {
		return this.nome.toLowerCase().hashCode();
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
