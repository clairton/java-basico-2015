package br.edu.horus.javabasico2015;

import java.time.LocalDate;

public class PessoaFisica extends Pessoa {
	private LocalDate nascidoEm;
	
	public PessoaFisica(String nome, LocalDate nascidoEm){
		super(nome);
		this.nascidoEm = nascidoEm;
	}
	
	public LocalDate getNascidoEm() {
		return nascidoEm;
	}
}
