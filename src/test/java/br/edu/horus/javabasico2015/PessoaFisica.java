package br.edu.horus.javabasico2015;

import java.time.LocalDate;

public class PessoaFisica extends Pessoa {
	private LocalDate nascidoEm;
	
	public PessoaFisica(String nome, LocalDate nascidoEm){
		super(nome);
		this.nascidoEm = nascidoEm;
	}
	
	public void setCpf(Cpf cpf){
		adicionar(cpf);
	}
	
	@Override
	public void adicionar(Documento documento) {
		if(getDocumentos()
			.stream()
			.filter(d -> Cpf.class.equals(d.getClass()))
			.count() > 0){
			throw new RuntimeException("ja existe um cpf, remova antes de add");
		}
		super.adicionar(documento);
	}
	
	public LocalDate getNascidoEm() {
		return nascidoEm;
	}
}
