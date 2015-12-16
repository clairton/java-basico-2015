package br.edu.horus.javabasico2015;


public class Cpf extends Documento {
	
	private String numero;
	
	public Cpf(String numero){
		//regex para validar o formato do cpf
		if(!numero.matches("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}")){
			throw new RuntimeException("CPF formato invalido"); 
		}
		this.numero = numero;
	}
	
	public String getNumero() {
		return numero;
	}
}
