package br.edu.horus.lacos;

public class Item {
	private String nome;
	
	private Double valor;
	
	public Item(String nome, Double valor){
		this.valor = valor;
		this.nome = nome;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public String getNome() {
		return nome;
	}
}
