package br.edu.horus.javabasico2015;

import java.math.BigDecimal;

public class Cliente {
	private Pessoa pessoa;
	
	private BigDecimal desconto = BigDecimal.ZERO;
	
	public Cliente(Pessoa pessoa){
		this.pessoa = pessoa;
	}
	
	public Cliente(Pessoa pessoa, BigDecimal desconto){
		//chama o construtor da propria classe
		this(pessoa);
		this.desconto = desconto;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Pessoa> T getPessoa() {
		return (T) pessoa;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}
	
	public String getNome() {
		return pessoa.getNome();
	}
}
