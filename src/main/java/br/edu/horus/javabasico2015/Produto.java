package br.edu.horus.javabasico2015;

public class Produto extends Item{
	
	private @Identificador String codigo;
	
	public Produto(String codigo, String nome, Double valor) {
		super(nome, valor);
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}
}
