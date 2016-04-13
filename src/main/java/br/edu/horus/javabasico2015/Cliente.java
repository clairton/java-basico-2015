package br.edu.horus.javabasico2015;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa;
	
	private BigDecimal desconto = BigDecimal.ZERO;
	
	@Deprecated
	public Cliente(){}
	
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
