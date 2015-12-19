package br.edu.horus.javabasico2015;

public class Cliente {
	private Pessoa pessoa;
	
	public Cliente(Pessoa pessoa){
		this.pessoa = pessoa;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
}
