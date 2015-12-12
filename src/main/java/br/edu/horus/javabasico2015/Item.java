package br.edu.horus.javabasico2015;

import java.util.Random;

public class Item extends Identificavel {
	private Integer id = new Random().nextInt();
	
	@Identificador(isCaseSensitive = false)
	private String nome;
	
	private Double valor;
	
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
}
